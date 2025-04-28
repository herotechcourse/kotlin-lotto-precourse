package lotto.controller

import lotto.validation.WinningNumbersValidator
import lotto.view.InputView.readWinningNumbers

object WinningNumbersHandler {
    fun readValidated(): List<String> {
        while (true) {
            val winningNumbers = readWinningNumbers()
            try {
                return validateAndReturn(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateAndReturn(winningNumberInput: String): List<String> {
        WinningNumbersValidator.validate(winningNumberInput)

        return winningNumberInput.split(',')
    }
}
