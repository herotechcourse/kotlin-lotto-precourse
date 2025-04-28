package lotto.io

import lotto.validators.InputValidator
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getSumOfMoney(): Int {
        var isValid = false
        var validatedInput = 0

        while (!isValid) {
            println("Please enter the purchase amount.")
            val input = Console.readLine()?.toIntOrNull()

            try {
                validatedInput = InputValidator.validateSumOfMoney(input)
                isValid = true
            } catch (e: Exception) {
                println(e.message)
            }
        }

        return validatedInput
    }

    fun getWinningNumbers(): List<Int> {
        var isValid = false
        var validatedInput: List<Int> = listOf()

        while (!isValid) {
            try {
                println("Please enter last week's winning numbers.")
                val input = Console.readLine().split(",").map {
                    it.trim().toIntOrNull()
                }

                validatedInput = InputValidator.validateNumbers(input)
                isValid = true
            } catch (e: Exception) {
                println(e.message)
            }
        }

        return validatedInput
    }

    fun getBonusNumber(): Int {
        var isValid = false
        var validatedInput = 0

        while (!isValid) {
            try {
                println("Please enter the bonus number.")
                val input = Console.readLine()?.toIntOrNull()
                validatedInput = InputValidator.validateNumberInRange(input)
                isValid = true
            } catch (e: Exception) {
                println(e.message)
            }
        }

        return validatedInput
    }
}
