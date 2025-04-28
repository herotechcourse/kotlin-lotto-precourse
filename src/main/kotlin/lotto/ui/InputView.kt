package lotto.ui

import lotto.Lotto
import lotto.ui.console.ConsoleIOInterface
import lotto.util.Constants

class InputView(private val console: ConsoleIOInterface) {
    private fun <T> readValidatedInput(prompt: String, parseAndValidate: () -> T): T {
        while (true) {
            console.print(prompt)
            try {
                return parseAndValidate()
            } catch (e: IllegalArgumentException) {
                e.message?.let { console.print(it) }
            }
        }
    }

    fun getPurchaseAmount(): Int {
        return readValidatedInput(Constants.PURCHASE_AMOUNT_PROMPT) {
            val amount = InputValidation.validatePurchaseAmount(console.read())
            amount
        }
    }

    fun getWinningNumbers(): Lotto {
        return readValidatedInput(Constants.WINNING_NUMBERS_PROMPT) {
            val winningNumbers = parseWinningNumbers(console.read())
            Lotto(winningNumbers)
        }
    }

    fun getBonusNumber(winningNumbers: Lotto): Int {
        return readValidatedInput(Constants.BONUS_NUMBER_PROMPT) {
            val number = InputValidation.validateBonusNumber(console.read(), winningNumbers.getNumbers())
            number
        }
    }

    private fun parseWinningNumbers(input: String): List<Int> {
        val numbers = input
            .split(",")
            .map {
                it.trim().toIntOrNull()
                    ?: throw IllegalArgumentException(Constants.ERROR_INVALID_WINNING_NUMBER)
            }
        return numbers
    }
}