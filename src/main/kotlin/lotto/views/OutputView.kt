package lotto.views

import lotto.LotteryResults
import lotto.Lotto

class OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>, ticketCount: Int){
        println("You have purchased $ticketCount tickets.")
        tickets.forEach { ticket ->
            println(ticket.getTicketNumbers())
        }
    }

    fun printWinningStatuses(winningStatuses: List<String>) {
        winningStatuses.forEach { status ->
            println(status)
        }
    }
}
