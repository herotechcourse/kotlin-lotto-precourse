package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.Validator

object InputView {
    fun inputPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid integer.")
    }

    fun inputWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val numbers = Console.readLine().split(",").map { it.trim().toInt() }
        Validator.validateNumberRange(numbers)
        return numbers
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        val bonus = Console.readLine().toInt()
        Validator.validateNumberRange(listOf(bonus))
        require(bonus !in winningNumbers) { "[ERROR] Bonus number must be unique." }
        return bonus
    }
}
