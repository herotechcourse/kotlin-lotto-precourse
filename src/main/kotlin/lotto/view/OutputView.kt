package lotto.view

import lotto.Lotto
import lotto.model.PrizeRank

class OutputView {

    companion object {
        fun printLotteries(lotteries: List<Lotto>) {
            println("You have purchased ${lotteries.size} tickets.")
            lotteries.forEach { lotto ->
                println(lotto.getNumbers().sorted())
            }

        }

        fun printWinningStatistics(result: Map<PrizeRank, Int>) {
            println("\nWinning Statistics")
            println("---")
            for (rank in PrizeRank.values()) {
                if (rank == PrizeRank.NONE) continue
                val count = result.getOrDefault(rank, 0)
                println("${formatRank(rank)} – ${count} tickets")
            }
        }

        fun printRateOfReturn(rateOfReturn: Double) {
            println("Total return rate is ${"%.1f".format(rateOfReturn)}%.")
        }

        private fun formatRank(rank: PrizeRank): String {
            return when (rank) {
                PrizeRank.SIX_MATCH -> "6 Matches (2,000,000,000 KRW)"
                PrizeRank.BONUS_MATCH -> "5 Matches + Bonus Ball (30,000,000 KRW)"
                PrizeRank.FIVE_MATCH -> "5 Matches (1,500,000 KRW)"
                PrizeRank.FOUR_MATCH -> "4 Matches (50,000 KRW)"
                PrizeRank.THREE_MATCH -> "3 Matches (5,000 KRW)"
                else -> ""
            }
        }
    }
}