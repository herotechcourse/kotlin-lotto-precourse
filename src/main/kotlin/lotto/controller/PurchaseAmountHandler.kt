package lotto.controller

import lotto.validation.PurchaseAmountValidator
import lotto.view.InputView

object PurchaseAmountHandler {
    fun readValidated(): Int {
        while (true) {
            val purchaseAmount = InputView.readPurchaseAmount()
            try {
                return validateAndReturn(purchaseAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateAndReturn(purchaseAmount: String): Int {
        PurchaseAmountValidator.validate(purchaseAmount)

        return purchaseAmount.toInt()
    }
}
