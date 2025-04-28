package lotto

class PrizeRankCalculator(val winningLotto: Lotto, val bonusLottoNumber: Int) {

    init {
        require(winningLotto.doesNotContain(bonusLottoNumber)) { DUPLICATED_NUMBER_ERROR }
        require(bonusLottoNumber in MIN_RANGE..MAX_RANGE) { NUMBER_OUT_OF_RANGE_ERROR }
    }

    fun calculateStatistics(lottoTickets: List<Lotto>): PrizeRankResult {
        val rankCounts = lottoTickets.map { lotto -> getPrizeRank(lotto) }
            .groupingBy { it }
            .eachCount()
        return PrizeRankResult(PrizeRank.entries.associateWith { rankCounts[it] ?: 0 })
    }

    private fun getPrizeRank(lotto: Lotto): PrizeRank {
        val matchingCount = lotto.countSameNumber(winningLotto)
        val hasBonusNumber = lotto.hasSameNumber(bonusLottoNumber)
        return PrizeRank.findBy(matchingCount, hasBonusNumber)
    }

    companion object {
        private const val MIN_RANGE: Int = 1
        private const val MAX_RANGE: Int = 45

        private const val NUMBER_OUT_OF_RANGE_ERROR: String =
            "[ERROR] Number must be between $MIN_RANGE and $MAX_RANGE."
        private const val DUPLICATED_NUMBER_ERROR: String =
            "[ERROR] Winning numbers and the bonus number should be unique."
    }
}
