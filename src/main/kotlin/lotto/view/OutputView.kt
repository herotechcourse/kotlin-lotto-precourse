package lotto.view

import lotto.domain.Rank
import lotto.domain.Result

object OutputView {

    fun printTickets(tickets: List<lotto.Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }

    /**
     * Prints the winning statistics and the profit rate.
     *
     * @param result the evaluated Result object
     * @param amount the purchase amount
     */
    fun printResult(result: Result, amount: Int) {
        println("\nWinning Statistics")
        println("---")

        val prizeResults = result.getPrizeResults()

        // Print results in the order required
        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
            .forEach { rank ->
                println(formatRankResult(rank, prizeResults.getOrDefault(rank, 0)))
            }

//        println("Total return rate is ${result.profitRate(amount)}%.")
        println("Total return rate is ${"%.1f".format(result.profitRate(amount))}%.")

    }

    private fun formatRankResult(rank: Rank, count: Int): String {
        val formattedPrize = "%,d".format(rank.prize)
        return when (rank) {
            Rank.SECOND -> "5 Matches + Bonus Ball (${formattedPrize} KRW) – ${count} tickets"
            else -> "${rank.matchCount} Matches (${formattedPrize} KRW) – ${count} tickets"
        }
    }
}
