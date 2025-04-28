package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constant.Constants

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(Constants.ERROR_INVALID_INPUT_NUMBER)
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
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
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException(Constants.ERROR_INVALID_INPUT_NUMBER)

        if (winningNumbers.contains(bonus)) {
            throw IllegalArgumentException(Constants.ERROR_DUPLICATE_BONUS_NUMBER)
        }

        return bonus
    }
}