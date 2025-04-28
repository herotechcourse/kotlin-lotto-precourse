package lotto.controller

import lotto.domain.PurchaseAmount
import lotto.view.InputView

class LottoController {
    fun run() {
        val purchaseAmount = PurchaseAmount.from(InputView.readPurchaseAmount())
    }
}