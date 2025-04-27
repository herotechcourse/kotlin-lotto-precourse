package lotto.controller

import lotto.validation.PurchaseAmountValidator
import lotto.view.InputView

object PurchaseAmountHandler {
    fun readValidatedBonusNumber(): Int {
        while (true) {
            val purchaseAmount = InputView.readPurchaseAmount()
            try {
                return handlePurchaseAmount(purchaseAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun handlePurchaseAmount(purchaseAmount: String): Int {
        PurchaseAmountValidator.validate(purchaseAmount)

        return purchaseAmount.toInt()
    }
}
