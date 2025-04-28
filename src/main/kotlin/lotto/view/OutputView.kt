package lotto.view

import lotto.domain.LottoTicket

object OutputView {
    fun printPurchaseCount(count: Int) {
        println("You have purchased $count tickets.")
    }

    fun printLottoTickets(tickets: List<LottoTicket>) {
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }
}