package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class InputView {
    fun lastWeekWinningNumbers(): String {
        val input = Console.readLine()
        return input
    }

    fun purchaseAmount() : String {
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

    fun validatePurchaseAmount(input: String) {
        require(input.isNotEmpty()) { "[ERROR] Input cannot be empty." }
        require(input.matches(Regex("\\d+"))) { "[ERROR] Input must be a number." }
    }
}