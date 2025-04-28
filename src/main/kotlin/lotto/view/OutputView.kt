package lotto.view

import lotto.Rank
import lotto.Lotto
import java.util.Locale

object OutputView {

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
            println(buildRankReport(rank, result[rank] ?: 0))
        }

        printProfitRate(result, purchaseAmount)
    }

    private fun buildRankReport(rank: Rank, count: Int): String {
        val matchInfo = if (rank.matchBonus) {
            "${rank.matchCount} Matches + Bonus Ball"
        } else {
            "${rank.matchCount} Matches"
        }
        val formattedPrize = formatOutput("%,d", rank.reward)
        return "$matchInfo ($formattedPrize KRW) – $count tickets"
    }

    private fun formatOutput(format: String, args: Any, locale: Locale = Locale.US): String {
        return String.format(locale, format, args)
    }

    private fun printProfitRate(result: Map<Rank, Int>, purchaseAmount: Int) {
        val totalReward = result.entries.sumOf { (rank, count) -> rank.reward.toLong() * count }
        val profitRate = totalReward.toDouble() / purchaseAmount * 100
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }
}
