package lotto.service

import lotto.domain.Rank

object ProfitCalculator {

    fun calculateProfitRate(rankResults: Map<Rank, Int>, purchaseAmount: Int): Double {
        val totalWinnings = rankResults.entries.sumOf { (rank, count) ->
            rank.prize.toLong() * count
        }

        return (totalWinnings.toDouble() / purchaseAmount) * 100
    }
}