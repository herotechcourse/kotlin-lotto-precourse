package lotto.factory

import lotto.view.input.InputView
import lotto.view.input.PurchaseAmountInputView
import lotto.enums.InputType

object InputViewFactory {
    fun createInputView(inputType: InputType): InputView {
        return when (inputType) {
            InputType.PURCHASE_AMOUNT -> PurchaseAmountInputView
            InputType.WINNING_NUMBERS -> lotto.view.input.WinningNumbersInputView
            InputType.BONUS_NUMBER -> lotto.view.input.BonusNumberInputView
        }
    }
}