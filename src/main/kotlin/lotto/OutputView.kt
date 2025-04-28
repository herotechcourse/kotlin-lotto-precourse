package lotto

import java.util.Locale

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
        println()
    }

    fun printResult(result: PrizeResult) {
        println("Winning Statistics")
        println("---")
        for ((rank, count) in result.count.entries.reversed()) {
            if (rank.matchCount == 0) continue
            val bonusText = if (rank.bonusRequired) " + Bonus Ball" else ""
            val prizeText = String.format(Locale.US, "%,d", rank.prizeMoney)
            println("${rank.matchCount} Matches${bonusText} ($prizeText KRW) – $count tickets")
        }
        println("Total return rate is ${kotlin.math.round(result.returnRate * 1000) / 10}%.")
    }
}