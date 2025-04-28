package lotto.view

import lotto.Lotto
import lotto.domain.Rank

object OutputView {

    fun printNumberOfTickets(numberOfTickets: Int) {
        println("You have purchased $numberOfTickets tickets.")
    }

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.getNumbers().sorted().joinToString(prefix = "[", postfix = "]"))
        }
    }

    private fun printRanks(rankTable: List<Int>) {
        Rank.entries
            .filter { it != Rank.ZERO }
            .forEach { rank ->
                val count = rankTable[rank.ordinal]
                val prizeText = "%,d KRW".format(rank.prize)
                println("${rank.label} ($prizeText) - $count tickets")
            }
    }

    private fun printReturnRate(returnRate: Double) {
        val rateText = "%,.1f%%".format(returnRate)
        println("Total return rate is $rateText.")
    }

    fun printWinningStatistics(rankTable: List<Int>, returnRate: Double) {
        println("Wining statistics")
        println("---")
        printRanks(rankTable)
        printReturnRate(returnRate)
    }
}