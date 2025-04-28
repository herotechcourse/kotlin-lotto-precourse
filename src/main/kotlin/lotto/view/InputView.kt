package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Messages
import lotto.util.Validator

class InputView {

    private fun <T> readInput(
        promptMessage: String,
        validator: (String) -> T
    ): T {
        while (true) {
            try {
                return validator(readUserInput(promptMessage))
            } catch (e: IllegalArgumentException) {
                showValidationError(e)
            }
        }
    }

    private fun readUserInput(message: String): String {
        Messages.display(message)
        return Console.readLine()
    }

    private fun showValidationError(e: IllegalArgumentException) {
        Messages.display(Messages.ERROR, e.message ?: Messages.ERROR_INVALID_INPUT)
    }

    fun readPurchaseAmount(): Int {
        return readInput(Messages.PURCHASE_AMOUNT) { input ->
            Validator.validatePurchaseAmount(input)
        }
    }

    fun readWinnerNumbers(): List<Int> {
        println()
        return readInput(Messages.WINNING_NUMBERS) { input ->
            Validator.validateWinningNumbers(input)
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println()
        return readInput(Messages.BONUS_NUMBER) { input ->
            Validator.validateBonusNumber(input, winningNumbers)
        }
    }
}