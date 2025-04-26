package lotto.controller

import lotto.model.Money
import lotto.view.InputView

class LottoController(
    private val inputView: InputView
) {

    fun run() {
        val purchaseAmountInput = inputView.readPurchaseAmount()
        val money = Money(purchaseAmountInput.toInt())

        val ticketCount = money.getTicketCount()
        println("Ticket count: $ticketCount") // temp
    }
}
