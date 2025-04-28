package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.util.Locale

object OutputView {

    private val prizeMoney =
        mapOf(3 to 5_000, 4 to 50_000, 5 to 1_500_000, 7 to 30_000_000, 6 to 2_000_000_000)

    private val displayOrder = listOf(3, 4, 5, 7, 6)


    fun printPurchasedTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket.getNumbers())
        }
    }

    fun printStatisticsHeader() {
        println("\nWinning Statistics")
        println("---")
    }

    fun printStatistics(matchesMap: Map<Int, Int>, returnRate: Double) {
        printStatisticsHeader()

        displayOrder.forEach { rank ->
            val count = matchesMap.getOrDefault(rank, 0)
            val prize = prizeMoney[rank] ?: 0
            val message = formatPrizeMessage(rank, prize)
            println("$message – $count tickets")
        }
        println(formatReturnRate(returnRate))
    }

    private fun formatPrizeMessage(rank: Int, prize: Int): String {
        return when (rank) {
            7 -> "5 Matches + Bonus Ball (${String.format(Locale.US, "%,d", prize)} KRW)"
            else -> "$rank Matches (${String.format(Locale.US, "%,d", prize)} KRW)"
        }
    }


    private fun formatReturnRate(returnRate: Double): String {
        return "Total return rate is %.1f%%.".format(Locale.US, returnRate)
    }
}