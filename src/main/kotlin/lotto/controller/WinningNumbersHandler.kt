package lotto.controller

import lotto.model.WinningNumbersParser
import lotto.validation.WinningNumbersValidator
import lotto.view.InputView.readWinningNumbers

object WinningNumbersHandler {
    fun readValidatedWinningNumbers(): List<String> {
        while (true) {
            val winningNumbers = readWinningNumbers()
            try {
                return handleWinningNumbers(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun handleWinningNumbers(winningNumberInput: String): List<String> {
        var parsedWinningNumbers: List<String> = WinningNumbersParser.parse(winningNumberInput)
        WinningNumbersValidator.validate(parsedWinningNumbers)

        return parsedWinningNumbers
    }
}
