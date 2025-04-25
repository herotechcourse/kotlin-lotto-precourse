package view

import lotto.Lotto
import lotto.Statistic

object Output {
    fun printPurchaseAmountInputMessage() = println("Please enter the purchase amount.")

    fun printPurchasedTicketsMessage(lottoTickets: List<Lotto>) {
        println("\nYou have purchased ${lottoTickets.size} tickets.")
        lottoTickets.forEach { println(it) }
    }

    fun printLastWeeksWinningNumbersInputMessage() = println("\nPlease enter last week's winning numbers.")

    fun printBonusNumberInputMessage() = println("\nPlease enter the bonus number.")

    fun printWinningStatisticsMessage(statistic: Statistic) {
        println("\nWinning Statistics\n---")

        statistic.sortedRankCounts().forEach { (rank, count) ->
            println("$rank – $count tickets")
        }

        println(String.format("Total return rate is %.1f%%.", statistic.returnRate() * 100))
    }
}
