package lotto

class PrizeRankCalculator(val winningLotto: Lotto, val bonusNumber: Number) {

    init {
        require(winningLotto.hasNotSameNumber(bonusNumber)) { DUPLICATED_NUMBER_ERROR }
    }

    fun calculateStatistics(lottoTickets: List<Lotto>): Map<PrizeRank, Int> {
        val rankCounts = lottoTickets.map { lotto -> getPrizeRank(lotto) }
            .groupingBy { it }
            .eachCount()
        return PrizeRank.entries.associateWith { rankCounts[it] ?: 0 }
    }

    private fun getPrizeRank(lotto: Lotto): PrizeRank {
        val matchingCount = lotto.getMatchingCount(winningLotto)
        val hasBonusNumber = lotto.hasBonusNumber(bonusNumber)
        return PrizeRank.of(matchingCount, hasBonusNumber)
    }

    companion object {
        private const val DUPLICATED_NUMBER_ERROR: String =
            "[ERROR] Winning numbers and the bonus number should be unique."
    }
}
