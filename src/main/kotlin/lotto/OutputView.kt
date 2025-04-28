package lotto

import java.text.NumberFormat

object OutputView {

    fun printTicketCount(count: Int) {
        println("\nYou have purchased $count tickets.")
    }

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.getNumbers().sorted().joinToString(", ", "[", "]"))
        }
    }

    fun printResult(ranks: List<Rank>, amountSpent: Int) {
        println("\nWinning Statistics")
        println("---")
        val formatter = NumberFormat.getNumberInstance()

        Rank.entries.filter { it != Rank.NONE }.forEach { rank ->
            val count = ranks.count { it == rank }
            val prizeFormatted = formatter.format(rank.prize)

            val description = when {
                rank == Rank.SECOND -> "${rank.matchCount} Matches + Bonus Ball"
                else -> "${rank.matchCount} Matches"
            }

            println("$description (${prizeFormatted} KRW) – $count tickets")
        }

        val totalPrize = ranks.sumOf { it.prize }
        val profitRate = totalPrize.toDouble() / amountSpent * 100
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }

}