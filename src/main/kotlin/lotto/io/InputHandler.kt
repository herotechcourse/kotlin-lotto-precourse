package lotto.io

import lotto.validators.InputValidator
import camp.nextstep.edu.missionutils.Console

object InputHandler {
    fun getSumOfMoney(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()?.toIntOrNull()

        return InputValidator.validateSumOfMoney(input)
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine().split(",").map {
            it.trim().toIntOrNull()
        }

        return InputValidator.validateNumbers(input)
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()?.toIntOrNull()

        return InputValidator.validateNumberInRange(input)
    }
}
