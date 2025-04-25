package lotto

import lotto.Game.Prize

class OutputView() {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets")
        tickets.forEach { println(it.getNumbers()) }
        println()
    }

    // format statistics string
    fun formatString(prize: Prize, count: Int): String {
        val matchDescription = if (prize.bonus) {
            "${prize.matchCount} Matches + Bonus Ball"
        } else {
            "${prize.matchCount} Matches"
        }
        val formattedAmount = "%,d".format(prize.amount) // Format amount with commas
        val ticketText = if (count == 1) "ticket" else "tickets"
            return "$matchDescription ($formattedAmount KRW) - $count $ticketText"
    }

    fun printStatistics(statistics:  List<Pair<Prize, Int>>) {
        println("Winning statistics:")
        println("---")
        statistics.reversed().forEach { println(formatString(it.first, it.second)) }
    }

    fun printReturnRate(returnRate: Double) {
        println("Total return rate is $returnRate%")
    }
}