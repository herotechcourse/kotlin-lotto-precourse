package lotto

import lotto.dto.PurchaseAmount
import lotto.factory.InputViewFactory

fun main() {
    // TODO: Implement the program
    val inputViewFactory = InputViewFactory()
    val inputView = inputViewFactory.getInputView()
    val purchaseAmount = PurchaseAmount(inputView.readInput())
    println("PurchaseAmount: ${purchaseAmount}")
    val ticketCounts = purchaseAmount.getTicketCount()
    println("TicketCounts: ${ticketCounts}")

    var tickets= mutableListOf<Lotto>()
    val lottos = Lottos(tickets,ticketCounts)

    for (lotto in lottos.getTickets()) {
        println("Lotto: ${lotto.getNumbers()}")
    }


}
