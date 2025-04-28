package lotto

import kotlin.math.round

class OutputView {
    companion object {
        private const val WINNING_STATISTICS_HEADER = "Winning Statistics"
        private const val SEPARATOR = "---"
        private const val BONUS_BALL_TEXT = " + Bonus Ball"
        private const val TICKETS_SUFFIX = " tickets"
    }

    fun printPrompt(message: String) {
        printSectionBreak()
        println(message)
    }

    fun printError(message: String) {
        println(message)
    }

    fun printPurchasedTickets(tickets: List<Lotto>) {
        printSectionBreak()
        printTicketCount(tickets.size)
        printTickets(tickets)
    }

    fun printWinningStatistics(rankCounts: Map<Rank, Int>, totalPurchaseAmount: Int) {
        printSectionBreak()
        printStatisticsHeader()
        printRankStatistics(rankCounts)
        printReturnRate(calculateReturnRate(rankCounts, totalPurchaseAmount))
    }

    private fun printSectionBreak() {
        println()
    }

    private fun printTicketCount(count: Int) {
        println("You have purchased $count tickets.")
    }

    private fun printTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.getNumbers())
        }
    }

    private fun printStatisticsHeader() {
        println(WINNING_STATISTICS_HEADER)
        println(SEPARATOR)
    }

    private fun printRankStatistics(rankCounts: Map<Rank, Int>) {
        getRanksInDisplayOrder().forEach { rank ->
            val count = rankCounts.getOrDefault(rank, 0)
            println(formatRankStatistic(rank, count))
        }
    }

    private fun getRanksInDisplayOrder(): List<Rank> {
        return listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
    }

    private fun formatRankStatistic(rank: Rank, count: Int): String {
        val bonusText = if (rank == Rank.SECOND) BONUS_BALL_TEXT else ""
        val prizeFormatted = String.format("%,d", rank.prizeMoney)
        return "${rank.matchCount} Matches$bonusText ($prizeFormatted KRW) – $count$TICKETS_SUFFIX"
    }

    private fun calculateReturnRate(rankCounts: Map<Rank, Int>, totalPurchaseAmount: Int): Double {
        val totalPrize = rankCounts.entries.sumOf { (rank, count) -> rank.prizeMoney * count }
        val returnRate = totalPrize * 100.0 / totalPurchaseAmount
        return round(returnRate * 10) / 10.0
    }

    private fun printReturnRate(returnRate: Double) {
        println("Total return rate is $returnRate%.")
    }
} 