package lotto.view

import lotto.Rank
import lotto.Lotto

object OutputView {

    private val DASH = '\u2013' // U+2013: en dash

    fun printPurchasedTickets(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printStatistics(result: Map<Rank, Int>, purchaseAmount: Int) {
        println("\nWinning Statistics")
        println("---")

        val ranksInOrder = listOf(
            Rank.FIFTH,   // 3 matches
            Rank.FOURTH,  // 4 matches
            Rank.THIRD,   // 5 matches
            Rank.SECOND,  // 5 matches + bonus
            Rank.FIRST    // 6 matches
        )

        ranksInOrder.forEach { rank ->
            val count = result[rank] ?: 0
            println("${formatRank(rank)} $DASH $count tickets")
        }

        printProfitRate(result, purchaseAmount)
    }

    private fun formatRank(rank: Rank): String {
        return when (rank) {
            Rank.FIRST -> "6 Matches (2,000,000,000 KRW)"
            Rank.SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
            Rank.THIRD -> "5 Matches (1,500,000 KRW)"
            Rank.FOURTH -> "4 Matches (50,000 KRW)"
            Rank.FIFTH -> "3 Matches (5,000 KRW)"
            else -> ""
        }
    }

    private fun printProfitRate(result: Map<Rank, Int>, purchaseAmount: Int) {
        val totalReward = result.entries.sumOf { (rank, count) -> rank.reward.toLong() * count }
        val profitRate = totalReward.toDouble() / purchaseAmount * 100
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}
