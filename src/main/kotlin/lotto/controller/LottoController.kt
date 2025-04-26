package lotto.controller

import lotto.presentation.InputView
import lotto.presentation.OutputView
import lotto.utils.InputValidator

class LottoController(
    private val inputValidator: InputValidator,
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private fun processPurchaseAmount(): Int {
        val input = inputView.promptInputForPurchaseAmount()
        return try {
            inputValidator.validateInput(input)
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e.message)
            processPurchaseAmount()
        }
    }

    fun run() {
        val purchaseAmount = processPurchaseAmount()
    }
}