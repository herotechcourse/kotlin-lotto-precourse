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
        return readValidatedInput("Please enter the purchase amount.") {
            val amount = validatePurchaseAmount(console.read())
            amount
        }
    }

    fun getWinningNumbers(): Lotto {
        return readValidatedInput("\nPlease enter last week's winning numbers.") {
            val winningNumbers = parseWinningNumbers(console.read())
            Lotto(winningNumbers)
        }
    }

    fun getBonusNumber(winningNumbers: Lotto): Int {
        return readValidatedInput("\nPlease enter the bonus number.") {
            val number = validateBonusNumber(console.read(), winningNumbers.getNumbers())
            number
        }
    }

    private fun validatePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("${Constants.ERROR_PREFIX} Input must be a valid number.")

        if (amount < Constants.MIN_PURCHASE_AMOUNT) {
            throw IllegalArgumentException("${Constants.ERROR_PREFIX} Purchase amount must be at least ${Constants.MIN_PURCHASE_AMOUNT} ${Constants.CURRENCY_UNIT}.")
        }
        if (amount % Constants.PURCHASE_AMOUNT_UNIT != 0) {
            throw IllegalArgumentException("${Constants.ERROR_PREFIX} Purchase amount must be in units of ${Constants.PURCHASE_AMOUNT_UNIT} ${Constants.CURRENCY_UNIT}.")
        }
        return amount
    }

    private fun parseWinningNumbers(input: String): List<Int> {
        val numbers = input
            .split(",")
            .map {
                it.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("${Constants.ERROR_PREFIX} All Lotto numbers must be numbers.")
            }
        return numbers
    }

    private fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException("${Constants.ERROR_PREFIX} Bonus number must be number.")
        if (number !in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER) {
            throw IllegalArgumentException("${Constants.ERROR_PREFIX} Bonus number must be between ${Constants.MIN_LOTTO_NUMBER} and ${Constants.MAX_LOTTO_NUMBER}.")
        }
        if (number in winningNumbers) {
            throw IllegalArgumentException("${Constants.ERROR_PREFIX} Bonus number must not be a duplicate of the winning numbers.")
        }
        return number
    }

}