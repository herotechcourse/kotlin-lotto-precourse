package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    private fun <T> readInput(
        promptMessage: String,
        validator: (String) -> T
    ): T {
        while (true) {
            try {
                Messages.display(promptMessage)
                val input = Console.readLine()
                return validator(input)
            } catch (e: IllegalArgumentException) {
                Messages.display(
                    Messages.ERROR,
                    e.message ?: Messages.ERROR_INVALID_INPUT
                )
            }
        }
    }

    fun readPurchaseAmount(): Int {
        return readInput(Messages.PURCHASE_AMOUNT, Validator::validatePurchaseAmount)
    }

    fun readWinnerNumbers(): List<Int> {
        return readInput(Messages.WINNING_NUMBERS, Validator::validateWinningNumbers)
    }

}