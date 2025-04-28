package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.MAX_NUMBER
import lotto.Constants.MIN_NUMBER
import lotto.Constants.TICKET_PRICE

object InputView {
    fun inputPurchaseAmount():Int {
        println("Please enter the purchase amount.")
        return try {
            val input = Console.readLine()
            val purchaseAmount = input.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Purchase amount must be a valid number.")
            require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than zero." }
            require(purchaseAmount % TICKET_PRICE == 0) { "[ERROR] Purchase amount must be divisible by 1000." }
            purchaseAmount
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            inputPurchaseAmount()
        }
    }

    fun inputLottoNumber():List<Int> {
        println("\nPlease enter last week's winning numbers.")
        try {
            val input = Console.readLine().removeWhiteSpaces()
            val winningNumbers = input.split(",").map {
                it.toIntOrNull() ?: throw IllegalArgumentException("All numbers must be valid integers")
            }
            require(winningNumbers.size == 6) { "[ERROR] You must enter exactly 6 numbers." }
            require(winningNumbers.distinct().size == winningNumbers.size) { "[ERROR] You cannot enter duplicate numbers." }
            require(winningNumbers.all { it in MIN_NUMBER..MAX_NUMBER }) { "[ERROR] All numbers must be between 1 and 45." }
            return winningNumbers
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            return inputLottoNumber()
        }
    }

    private fun String.removeWhiteSpaces() = replace("\\s".toRegex(), "")

    fun inputBonusNumber(winningNumbers: List<Int>):Int {
        println("\nPlease enter the bonus number.")
        try {
            val input = Console.readLine()
            val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be a valid integer.")
            require(bonusNumber in MIN_NUMBER..MAX_NUMBER) { "[ERROR] Bonus number must be between 1 and 45." }
            require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Bonus number cannot be one of the winning numbers." }
            return bonusNumber
        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            return inputBonusNumber(winningNumbers)
        }
    }
}
