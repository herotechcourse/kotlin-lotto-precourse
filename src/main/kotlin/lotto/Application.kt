package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    val tickets = LottoGenerator.generateTicket(amount)
    OutputView.printTickets(tickets)
}