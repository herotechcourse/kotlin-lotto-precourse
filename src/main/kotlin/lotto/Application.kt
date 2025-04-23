package lotto

import lotto.handler.InputHandler
import lotto.handler.OutputHandler
import lotto.service.LottoManager

fun main() {
    // TODO: Implement the program
    val purchasedAmount = InputHandler.getPurchaseAmount();

    val ticketAmount = purchasedAmount / 1000

    val tickets = LottoManager.generateMultipleTickets(ticketAmount)

    val outputHandler = lotto.handler.OutputHandler()
    outputHandler.displayPurchasedTicketsInfo(tickets)
}
