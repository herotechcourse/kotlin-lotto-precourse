package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

class InputView {
    fun lastWeekWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = Console.readLine()
                validateLasWeekWinningNumbers(input)
                val numbers = inputSplitter(input)
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun purchaseAmount(): String {
        while (true) {
            try {
                val input = Console.readLine()
                validatePurchaseAmount(input)
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun lastWeekBonusNumber(): String {
        val input = Console.readLine()
        return input
    }

    private fun inputSplitter(input: String): List<Int> {
        val numbers = input.split(",")
            .map {
                require(it.isNotBlank()) { "[ERROR] Empty value is not allowed." }
                it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Only numbers are allowed.")
            }

        validateLastWeekLottoNumbers(numbers)

        return numbers
    }

    private fun validateLastWeekLottoNumbers(numbers: List<Int>) {
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Duplicate numbers are not allowed." }
    }

    private fun validateLasWeekWinningNumbers(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Input cannot be empty." }
    }

    fun validatePurchaseAmount(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Input cannot be empty." }
        require(input.matches(Regex("\\d+"))) { "[ERROR] Input must be a number." }
    }
}