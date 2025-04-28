package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constant.Constants

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        while (true) {
            try {
                val input = Console.readLine()
                return input.toIntOrNull() ?: throw IllegalArgumentException(Constants.ERROR_INVALID_INPUT_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        while (true) {
            try {
                val input = Console.readLine()
                val numbers = input.split(",")
                    .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException(Constants.ERROR_INVALID_INPUT_NUMBER) }

                if (numbers.size != 6) {
                    throw IllegalArgumentException(Constants.ERROR_NOT_SIX_WINNING_NUMBERS)
                }
                if (numbers.distinct().size != 6) {
                    throw IllegalArgumentException(Constants.ERROR_DUPLICATE_WINNING_NUMBER)
                }
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        while (true) {
            try {
                val input = Console.readLine()
                val bonus = input.toIntOrNull()
                    ?: throw IllegalArgumentException(Constants.ERROR_INVALID_INPUT_NUMBER)

                if (winningNumbers.contains(bonus)) {
                    throw IllegalArgumentException(Constants.ERROR_DUPLICATE_BONUS_NUMBER)
                }
                return bonus
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}