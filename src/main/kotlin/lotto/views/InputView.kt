package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.common.ErrorMessages

object InputView {

    fun readPurchaseAmount(): Int = retryInput {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull()

        if (amount == null || amount <= 0 || amount % 1000 != 0) {
            throw IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_AMOUNT)
        }

        amount
    }

    fun readWinningNumbers(): List<Int> = retryInput {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() }

        if (numbers.any { it == null } || numbers.size != 6) {
            throw IllegalArgumentException(ErrorMessages.INVALID_WINNING_COUNT)
        }

        val validNumbers = numbers.filterNotNull()

        if (validNumbers.toSet().size != 6) {
            throw IllegalArgumentException(ErrorMessages.DUPLICATE_WINNING_NUMBERS)
        }

        if (validNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException(ErrorMessages.OUT_OF_RANGE_WINNING_NUMBER)
        }

        validNumbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int = retryInput {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessages.INVALID_BONUS_NUMBER)

        if (bonus !in 1..45) {
            throw IllegalArgumentException(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE)
        }

        if (bonus in winningNumbers) {
            throw IllegalArgumentException(ErrorMessages.BONUS_NUMBER_DUPLICATE)
        }

        bonus
    }

    private fun <T> retryInput(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}