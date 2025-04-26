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
            .map { it.toInt() }
        return numbers
    }

    private fun validateLasWeekWinningNumbers(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Input cannot be empty." }
    }

    fun validatePurchaseAmount(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Input cannot be empty." }
        require(input.matches(Regex("\\d+"))) { "[ERROR] Input must be a number." }
    }
}