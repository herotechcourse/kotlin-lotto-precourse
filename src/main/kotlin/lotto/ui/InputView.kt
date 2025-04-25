package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.Lotto
import lotto.util.Constants

class InputView {
    companion object{
        private fun <T> readValidatedInput(prompt: String, parseAndValidate: () -> T): T {
            while (true) {
                println(prompt)
                try {
                    return parseAndValidate()
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        fun getPurchaseAmount(): Int {
            return readValidatedInput("Please enter the purchase amount.") {
                val amount = Console.readLine().toIntOrNull()
                    ?: throw IllegalArgumentException("${Constants.ERROR_PREFIX} Input must be a valid number.")
                validatePurchaseAmount(amount)
                amount
            }
        }

        fun getWinningNumbers(): Lotto {
            return readValidatedInput("\nPlease enter the last week's winning numbers.") {
                val winningNumbers = parseWinningNumbers(Console.readLine())
                Lotto(winningNumbers)
            }
        }

        fun getBonusNumber(winningNumbers: Lotto): Int {
            return readValidatedInput("\nPlease enter the bonus number."){
                val number = Console.readLine().toIntOrNull()
                    ?: throw IllegalArgumentException("${Constants.ERROR_PREFIX} Bonus number must be number.")
                validateBonusNumber(number, winningNumbers.getNumbers())
                number
            }
        }

        private fun validatePurchaseAmount(amount: Int) {
            if (amount < Constants.MIN_PURCHASE_AMOUNT) {
                throw IllegalArgumentException("${Constants.ERROR_PREFIX} Purchase amount must be at least ${Constants.MIN_PURCHASE_AMOUNT} ${Constants.CURRENCY_UNIT}.")
            }
            if (amount % Constants.PURCHASE_AMOUNT_UNIT != 0) {
                throw IllegalArgumentException("${Constants.ERROR_PREFIX} Purchase amount must be in units of ${Constants.PURCHASE_AMOUNT_UNIT} ${Constants.CURRENCY_UNIT}.")
            }
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

        private fun validateBonusNumber(number: Int, winningNumbers: List<Int>) {
            if (number !in 1..45) {
                throw IllegalArgumentException("${Constants.ERROR_PREFIX} Bonus number must be between 1 and 45.")
            }
            if (number in winningNumbers) {
                throw IllegalArgumentException("${Constants.ERROR_PREFIX} Bonus number must not be a duplicate of the winning numbers.")
            }
        }
    }
}