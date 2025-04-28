package lotto.controller

import lotto.model.WinningNumbersParser
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
        val parsedWinningNumbers = WinningNumbersParser.parse(winningNumberInput)
        WinningNumbersValidator.validate(parsedWinningNumbers)

        return parsedWinningNumbers
    }
}
