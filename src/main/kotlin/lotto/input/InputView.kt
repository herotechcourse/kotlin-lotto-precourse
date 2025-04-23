package lotto.input

import camp.nextstep.edu.missionutils.Console
import lotto.util.Messages

class InputView {
    companion object {
        fun readPurchaseAmount(): Int = readIntWithValidation(Messages.PROMPT_PURCHASE_AMOUNT) {
            it % 1000 == 0
        }

        fun readWinningNumbers(): List<Int> = readIntListWithValidation(Messages.PROMPT_WINNING_NUMBERS) {
            it.size == 6 && it.all { num -> num in 1..45 } && it.distinct().size == 6
        }

        fun readBonusNumber(): Int = readIntWithValidation(Messages.PROMPT_BONUS_NUMBER) {
            it in 1..45
        }

        private fun readIntWithValidation(prompt: String, validate: (Int) -> Boolean): Int {
            while (true) {
                try {
                    println(prompt)
                    val input = Console.readLine()
                    val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid input: $input is not a number.")
                    if (!validate(number)) {
                        throw IllegalArgumentException("[ERROR] Input does not meet criteria.")
                    }
                    return number
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun readIntListWithValidation(prompt: String, validate: (List<Int>) -> Boolean): List<Int> {
            while (true) {
                try {
                    println(prompt)
                    val input = Console.readLine()
                    val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] $it is not a valid integer.") }
                    if (!validate(numbers)) {
                        throw IllegalArgumentException("[ERROR] List of numbers does not meet criteria.")
                    }
                    return numbers
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }
    }
}








