package lotto.factory

import lotto.view.input.InputView
import lotto.view.input.PurchaseAmountInputView

class InputViewFactory {
    fun getInputView(): InputView {
        return PurchaseAmountInputView
    }
}