package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid purchase amount. Please enter a valid number.")
        }
    }
    
    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        val input = Console.readLine()
        
        try {
            val numbers = input.split(",").map { it.trim().toInt() }
            validateNumbers(numbers)
            return numbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid winning numbers. Please enter valid numbers separated by commas.")
        }
    }
    
    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        val input = Console.readLine()
        
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid bonus number. Please enter a valid number.")
        }
    }
    
    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] You must enter exactly 6 winning numbers.")
        }
        
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
        }
        
        if (numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }
    }
}