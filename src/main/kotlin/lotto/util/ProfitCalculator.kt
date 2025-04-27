package lotto.util

import lotto.model.Rank

object ProfitCalculator {

    fun calculateProfitRate(result: Map<Rank, Int>): Double {
        val totalPrize = result.entries.sumOf { it.key.prize * it.value }
        val totalCost = result.values.sum() * 1000
        return if (totalCost == 0) 0.0 else (totalPrize.toDouble() / totalCost) * 100
    }
}