package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return retryInput {
            val input = Console.readLine().trim()
            Validator.validatePurchaseAmount(input)
            input.toInt()
        }
    }


    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated).")
        return retryInput {
            val input = Console.readLine().trim()
            val numbers = input.split(",").map { it.trim() }
            Validator.validateNumberListSize(numbers)
            Validator.validateAllNumbers(numbers)
            numbers.map { it.toInt() }
        }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return retryInput {
            val input = Console.readLine().trim()
            Validator.validateNumber(input)
            input.toInt()
        }
    }

    private fun <T> retryInput(action: () -> T): T {
        return try {
            action()
        } catch (e: IllegalArgumentException) {
            println(e.message)  // Print [ERROR] message
            retryInput(action)  // Retry input
        }
    }
}
