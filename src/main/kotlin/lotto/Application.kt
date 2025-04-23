package lotto

import lotto.utils.InputView
import lotto.utils.LottoMachine

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val ticketCount = LottoMachine.calculateTicketCount(purchaseAmount)

    println("\nYou have purchased $ticketCount tickets.")

    val tickets = LottoMachine.generateTickets(ticketCount)

    for (ticket in tickets) {
        println(ticket.display())
    }

}
