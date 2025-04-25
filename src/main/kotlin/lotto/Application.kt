package lotto

import utils.InputView
import utils.Purchase

fun main() {
    // TODO: Implement the program
    var amount = InputView.getAmount()
    val purchase = Purchase.make(amount)
    purchase.displayPurchase()

}
