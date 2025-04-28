package lotto.controller

import lotto.domain.PurchaseAmount
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val purchaseAmount = getPurchaseAmount()
    }

    fun getPurchaseAmount(): PurchaseAmount {
        while(true){
            try {
                return PurchaseAmount.from(InputView.readPurchaseAmount())
            } catch (e: IllegalArgumentException) {
                e.message?.let { OutputView.printError(it) }
            }
        }
    }
}