package lotto

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount:")
        val input = Console.readLine()

        return validatePurchaseAmount(input)
    }

    private fun validatePurchaseAmount(input: String): Int {
        try {
            val amount = input.toInt()
            require(amount > 0) { "[ERROR] Purchase amount must be a positive number." }
            require(amount % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1000." }
            return amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format.")
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        return validateWinningNumbers(input)
    }

    private fun validateWinningNumbers(input: String): List<Int> {
        try {
            val numbers = input.split(",").map { it.trim().toInt() }
            
            require(numbers.size == 6) { "[ERROR] You must enter exactly 6 winning numbers." }
            require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
            require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
            
            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format.")
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number:")
        val input = Console.readLine()

        return validateBonusNumber(input, winningNumbers)
    }   

    private fun validateBonusNumber(input: String, winningNumbers: List<Int>): Int {
        try {
            val number = input.toInt()

            require(number in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
            require(number !in winningNumbers) { "[ERROR] Bonus number must be different from the winning numbers." }
            
            return number   
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid number format.")
        }
    }
}