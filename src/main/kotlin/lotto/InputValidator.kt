package lotto

import camp.nextstep.edu.missionutils.Console

object InputValidator {

    fun getValidPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine()
                return validatePurchaseAmountInput(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getValidLotteryNumbers(): List<Int> {
        while (true) {
            println("Please enter last week's winning numbers.")
            val inputLine = Console.readLine()
            try {
                return validateLotteryNumbersInput(inputLine)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getValidBonusNumber(): Int {
        while (true) {
            println("Please enter the bonus number.")
            val inputLine = Console.readLine()
            try {
                return validateBonusNumber(inputLine)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validatePurchaseAmountInput(input: String): Int {
        val validAmount =
            input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] The amount has to be a number!")
        require(validAmount % 1000 == 0) { "[ERROR] The purchase amount must be divisible by 1000!" }
        return validAmount
    }

    fun validateLotteryNumbersInput(input: String): List<Int> {
        return input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] All entries must be numbers!") }
    }

    fun validateBonusNumber(input: String): Int {
        val bonusNumber =
            input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] The bonus number has to be a number!")
        require(bonusNumber in 1..45) { "[ERROR] Each number must be between 1 and 45." }
        return bonusNumber
    }
}
