package lotto.controller

import lotto.model.Money
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val purchaseAmountInput = inputView.readPurchaseAmount()
        val money = Money(purchaseAmountInput.toInt())

        val ticketCount = money.getTicketCount()
        outputView.printTicketCount(ticketCount)
    }
}
