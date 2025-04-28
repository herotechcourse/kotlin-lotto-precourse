package lotto

import lotto.dto.PurchaseAmount
import lotto.factory.InputViewFactory

fun main() {
    // TODO: Implement the program
    val inputViewFactory = InputViewFactory()
    val inputView = inputViewFactory.getInputView()
    val purchaseAmount = PurchaseAmount(inputView.readInput())
    println("PurchaseAmount: ${purchaseAmount.amountValue}")
    println("TicketCounts: ${purchaseAmount.getTicketCount()}")

}
