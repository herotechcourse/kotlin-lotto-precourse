package lotto.view

import camp.nextstep.edu.missionutils.Console

private const val ERROR_INVALID_AMOUNT = "[ERROR] Purchase amount must be a valid number"
private const val ERROR_INVALID_NUMBER = "[ERROR] Input must be a valid number."
private const val ERROR_INVALID_BONUS_NUMBER = "[ERROR] Bonus number must be a valid number."

class InputView {
    fun readPurchaseAmount(): Int {
        println("\nPlease enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_INVALID_AMOUNT)
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        return Console.readLine()
            .split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException(ERROR_INVALID_NUMBER) }
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(ERROR_INVALID_BONUS_NUMBER)
    }
}