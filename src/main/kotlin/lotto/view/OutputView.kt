package lotto.view

import lotto.domain.PrizeRank

/**
 * Handles all console output for the Lotto game.
 */
object OutputView: IOutputView {

    /**
     * Prints purchased tickets.
     */
    override fun printTickets(tickets: List<List<Int>>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
        println()
    }

    /**
     * Prints winning statistics and total return rate.
     */
    override fun printStatistics(resultCounts: Map<PrizeRank, Int>, returnRate: Double) {
        println("Winning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.FIFTH, 0)} tickets")
        println("4 Matches (50,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.FOURTH, 0)} tickets")
        println("5 Matches (1,500,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.THIRD, 0)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.SECOND, 0)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${resultCounts.getOrDefault(PrizeRank.FIRST, 0)} tickets")
        println("Total return rate is $returnRate%.")
    }

    /**
     * Prints error messages with the required prefix.
     */
    override fun printError(message: String) {
        println("[ERROR]: $message")
    }
}
