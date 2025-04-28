package lotto.service

import lotto.common.Constants
import lotto.domain.PrizeRank

object ProfitCaculator {
    fun calculate(map: Map<PrizeRank, Int>, purchaseAmount: Int): String {
        val totalProfit = map.entries.sumOf { (result, count) -> result.prize.toLong() * count }
        return format((totalProfit.toDouble() / (purchaseAmount * Constants.TICKET_PRICE)) * 100)
    }

    private fun format(rate: Double): String {
        return String.format("%.1f", rate)
    }
}