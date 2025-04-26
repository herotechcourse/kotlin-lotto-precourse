package lotto.controller

import lotto.presentation.InputView
import lotto.utils.InputValidator

class LottoController(
    private val inputValidator: InputValidator,
    private val inputView: InputView,
) {
    private fun processPurchaseAmount(): Int {
        val input = inputView.promptInputForPurchaseAmount()
        return try {
            inputValidator.validateInput(input)
        } catch (e: IllegalArgumentException) {
            processPurchaseAmount()
        }
    }

    fun run() {
        val purchaseAmount = processPurchaseAmount()

    }
}