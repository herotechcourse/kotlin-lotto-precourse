package view

import lotto.LottoRank

object OutputView {
    fun promptPurchaseAmount() {
        println("Please enter the purchase amount.")
    }

    fun promptWinningNumbers() {
        println("Please enter last week's winning numbers.")
    }

    fun promptBonusNumber() {
        println("Please enter the bonus number.")
    }

    fun printErrorMessage(message: String) {
        println("[ERROR] $message")
    }

    fun printTicketCount(count: Int) {
        println("You have purchased $count tickets")
    }

    fun printTickets(tickets: List<List<Int>>) {
        tickets.forEach { ticket ->
            println(ticket.joinToString(", ", "[", "]"))
        }
    }

    fun printWinningStatistics(statistics: Map<LottoRank, Int>){
        println("Winning Statistics")
        println("---")
        LottoRank.values().forEach { rank ->
            val count = statistics.getOrDefault(rank, 0)
            println("${rank.description} – $count tickets")
        }
    }

    fun printProfitRate(rate: String) {
        println("Total return rate is $rate")
    }

}