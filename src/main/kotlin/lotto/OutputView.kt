package lotto

import lotto.Game.Prize

class OutputView() {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
        println()
    }

    fun formatString(prize: Prize, count: Int): String {
        val matchDescription = if (prize.bonus) {
            "${prize.matchCount} Matches + Bonus Ball"
        } else {
            "${prize.matchCount} Matches"
        }
        val formattedAmount = "%,d".format(prize.amount)
        return "$matchDescription ($formattedAmount KRW) – $count tickets"
    }

    fun printStatistics(statistics:  List<Pair<Prize, Int>>) {
        println("Winning statistics:")
        println("---")
        statistics.reversed().forEach { println(formatString(it.first, it.second)) }
    }

    fun printReturnRate(returnRate: Double) {
        println(String.format("Total return rate is %.1f%%.", returnRate))
    }
}