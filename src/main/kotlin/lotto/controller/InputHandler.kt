package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.support.Validator


object InputHandler {
    fun requestPurchaseAmount(): Int = generateSequence {
        try {
            OutputView.printPurchaseAmountPrompt()
            val amount = InputView.getLineAsInt()
            Validator.validatePurchaseAmount(amount)
            amount
        }
        catch (e: IllegalArgumentException){
            OutputView.printErrorMessage(e.message)
            null
        }
    }.first()
}