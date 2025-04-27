package lotto.service

import lotto.domain.PrizeRank

object ProfitCaculator {
    private val TICKET_PRICE: Int = 1000
    fun calculate(map: Map<PrizeRank, Int>, purchaseAmount: Int): String {
        val totalProfit = map.entries.sumOf { (result, count) -> result.prize.toLong() * count }
        return format((totalProfit.toDouble() / (purchaseAmount * TICKET_PRICE)) * 100)
    }

    private fun format(rate: Double): String {
        return String.format("%.1f", rate)
    }
}