package lotto

import lotto.LottoPrize.*

data class LottoStatistics(val statistics: List<LottoStatistic>) {

    fun updateTicketCount(matchCount: Int, hasBonus: Boolean) {
        statistics.forEach { lottoPrizeResult ->
            if (lottoPrizeResult.isMatch(matchCount, hasBonus)) {
                lottoPrizeResult.updateTicketCount()
            }
        }
    }

    fun getProfitRate(purchaseAmount: Int) = (getTotalPrizeAmount() / purchaseAmount) * PERCENTAGE

    private fun getTotalPrizeAmount() = statistics.sumOf { it.getPrizeAmount() }.toDouble()

    override fun toString() = statistics.joinToString(NEW_LINE) { it.toString() }

    companion object {

        private const val PERCENTAGE = 100
        private const val NEW_LINE = "\n"

        fun of() = LottoStatistics(
            listOf(
                LottoStatistic(THREE_MATCHES),
                LottoStatistic(FOUR_MATCHES),
                LottoStatistic(FIVE_MATCHES),
                LottoStatistic(FIVE_MATCHES_BONUS),
                LottoStatistic(SIX_MATCHES),
            )
        )
    }
}
