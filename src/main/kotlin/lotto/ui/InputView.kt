package lotto.ui

import lotto.Lotto
import lotto.util.Constants

class InputView(private val console: ConsoleIoInterface) {

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
            val amount = validatePurchaseAmount(console.read())
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
            val number = validateBonusNumber(console.read(), winningNumbers.getNumbers())
            number
        }
    }

    private fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException(Constants.ERROR_INVALID_NUMBER)

        if (amount < Constants.MIN_PURCHASE_AMOUNT) {
            throw IllegalArgumentException(Constants.ERROR_INVALID_PURCHASE_AMOUNT)
        }
        if (amount % Constants.PURCHASE_AMOUNT_UNIT != 0) {
            throw IllegalArgumentException(Constants.ERROR_INVALID_PURCHASE_UNIT)
        }
        return amount
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

    private fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException(Constants.ERROR_INVALID_BONUS_NUMBER)
        if (number !in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER) {
            throw IllegalArgumentException(Constants.ERROR_BONUS_OUT_OF_RANGE)
        }
        if (number in winningNumbers) {
            throw IllegalArgumentException(Constants.ERROR_DUPLICATE_BONUS_NUMBER)
        }
        return number
    }

}