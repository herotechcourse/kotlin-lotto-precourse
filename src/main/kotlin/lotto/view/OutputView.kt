package lotto.view

import lotto.model.MatchResult
import lotto.util.PrizeRank

object OutputView {
    fun printPurchasedTickets(count: Int, tickets: List<List<Int>>) {
        println("\nYou have purchased ${count} tickets.")
        tickets.forEach { numbers -> println(numbers.sorted()) }
    }

    fun printWinningStatistics(result: MatchResult) {
        printHeader()
        printPrizeResults(result)
        printProfitRate(result)
    }

    private fun printHeader() {
        println("\nWinning Statistics")
        println("---")
    }

    private fun printPrizeResults(result: MatchResult) {
        printRankResult(PrizeRank.FIFTH, result)
        printRankResult(PrizeRank.FOURTH, result)
        printRankResult(PrizeRank.THIRD, result)
        printRankResult(PrizeRank.SECOND, result)
        printRankResult(PrizeRank.FIRST, result)
    }

    private fun printRankResult(rank: PrizeRank, result: MatchResult) {
        val count = result.rankCounts[rank] ?: 0
        when (rank) {
            PrizeRank.SECOND -> println("5 Matches + Bonus Ball (${formatPrizeMoney(rank.prizeMoney)} KRW) – ${count} tickets")
            PrizeRank.THIRD -> println("5 Matches (${formatPrizeMoney(rank.prizeMoney)} KRW) – ${count} tickets")
            else -> println("${rank.matchCount} Matches (${formatPrizeMoney(rank.prizeMoney)} KRW) – ${count} tickets")
        }
    }

    private fun formatPrizeMoney(amount: Int): String {
        return "%,d".format(amount)
    }

    private fun printProfitRate(result: MatchResult) {
        val profitRate = String.format("%.1f", result.calculateProfitRate())
        println("Total return rate is ${profitRate}%.")
    }
}