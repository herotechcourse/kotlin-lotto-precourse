package lotto

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

class InputView {
    fun lastWeekWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = Console.readLine()
                validateLastWeekWinningNumbers(input)
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

    fun lastWeekBonusNumber(lastWeekWinningNumbers: List<Int>): Int {
        while (true) {
            try {
                val input = Console.readLine()
                validateLastWeekBonusNumber(input)
                val bonusNumber =
                    input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Only numbers are allowed.")
                validateBonusNumber(bonusNumber, lastWeekWinningNumbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
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

    private fun validateBonusNumber(bonusNumber: Int, lastWeekWinningNumbers: List<Int>) {
        require(bonusNumber in LOTTO_START_NUMBER..LOTTO_END_NUMBER) { "[ERROR] Number must be between 1 and 45." }
        require(bonusNumber !in lastWeekWinningNumbers) { "[ERROR] Duplicate numbers are not allowed." }
    }

    private fun validateLastWeekBonusNumber(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Bonus number cannot be empty." }
        input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Only number is allowed.")
    }

    private fun validateLastWeekLottoNumbers(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "[ERROR] The number of lotto must be six." }
        require(numbers.all { it in LOTTO_START_NUMBER..LOTTO_END_NUMBER }) { "[ERROR] Numbers must be between 1 and 45." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Duplicate numbers are not allowed." }
    }

    private fun validateLastWeekWinningNumbers(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Input cannot be empty." }
    }

    fun validatePurchaseAmount(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Input cannot be empty." }
        require(input.matches(Regex("\\d+"))) { "[ERROR] Input must be a number." }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
    }
}