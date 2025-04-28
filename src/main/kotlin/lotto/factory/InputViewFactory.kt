package lotto.factory

import lotto.view.input.InputView
import lotto.enums.InputType
import lotto.view.input.PurchaseAmountInputView
import lotto.view.input.WinningNumbersInputView
import lotto.view.input.BonusNumberInputView

object InputViewFactory {
    fun createInputView(inputType: InputType): InputView {
        return when (inputType) {
            InputType.PURCHASE_AMOUNT -> PurchaseAmountInputView
            InputType.WINNING_NUMBERS -> WinningNumbersInputView
            InputType.BONUS_NUMBER -> BonusNumberInputView
        }
    }
}