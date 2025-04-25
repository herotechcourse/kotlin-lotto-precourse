package lotto

import lotto.domain.InputValidator
import lotto.messages.PromptMessages
import lotto.view.InputView

fun main() {

    var purchaseAmount: Int
    while (true) {
        val input = InputView().readOneLine(PromptMessages.PURCHASE_AMOUNT.message)
        try {
            purchaseAmount = InputValidator().validatePurchaseInput(input)
            break
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }

}
