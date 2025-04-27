package lotto.business

import lotto.*
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoController {
    private fun inputPurchaseAmount(): PurchaseAmount {
        while (true) {
            try {
                val purchaseAmountInput = InputView.getPurchaseAmount()
                return PurchaseAmount.from(purchaseAmount = purchaseAmountInput)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}