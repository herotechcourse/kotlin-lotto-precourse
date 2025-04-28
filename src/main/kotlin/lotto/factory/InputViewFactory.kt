package lotto.factory

import lotto.view.input.InputView
import lotto.view.input.PurchaseAmountInputView

object InputViewFactory {
    fun getInputView(): InputView {
        return PurchaseAmountInputView
    }
}