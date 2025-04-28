package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validation

object InputView {
    private fun <T> readValidInput(prompt: String, validationAction: (String) -> T): T {
        while (true) {
            println(prompt)
            val input = Console.readLine()
            try {
                return validationAction(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readPurchaseAmount(): Int {
        return readValidInput("Please enter the purchase amount.") {
            input -> val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
            Validation.validateLottoAmount(amount)
            amount
        }
    }

    fun readWinningNumbers(): List<Int> {
        return readValidInput("\nPlease enter last week's winning numbers.") {
            input -> val numbers = input.split(",").map {
                it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be numeric.")
        }
            Validation.validateWinningNumbers(numbers)
            numbers
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        return readValidInput("\nPlease enter the bonus number.") { input ->
            val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
            Validation.validateBonusNumber(bonus, winningNumbers)
            bonus
        }
    }
}