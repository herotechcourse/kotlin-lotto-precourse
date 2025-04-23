package lotto

import lotto.utils.InputView
import lotto.utils.LottoMachine
import lotto.utils.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val ticketCount = LottoMachine.calculateTicketCount(purchaseAmount)
    val tickets = LottoMachine.generateTickets(ticketCount)

    OutputView.printTickets(tickets)

}
