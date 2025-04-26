package lotto

class PrizeRankCalculator(val winningLotto: Lotto, val bonusNumber: Number) {

    init {
        require(winningLotto.doesNotContain(bonusNumber)) { DUPLICATED_NUMBER_ERROR }
    }

    fun calculateStatistics(lottoTickets: List<Lotto>): PrizeRankResult {
        val rankCounts = lottoTickets.map { lotto -> getPrizeRank(lotto) }
            .groupingBy { it }
            .eachCount()
        return PrizeRankResult(PrizeRank.entries.associateWith { rankCounts[it] ?: 0 })
    }

    private fun getPrizeRank(lotto: Lotto): PrizeRank {
        val matchingCount = lotto.countMatchingNumber(winningLotto)
        val hasBonusNumber = lotto.hasSameNumber(bonusNumber)
        return PrizeRank.findBy(matchingCount, hasBonusNumber)
    }

    companion object {
        private const val DUPLICATED_NUMBER_ERROR: String =
            "[ERROR] Winning numbers and the bonus number should be unique."
    }
}
