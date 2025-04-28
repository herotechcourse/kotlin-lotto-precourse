package lotto.views

import camp.nextstep.edu.missionutils.Console

class InputView {
    internal var validatedWinningNumbers = emptyList<Int>()

    // Ask user to input the purchase amount
    fun getPurchaseAmount(): Int {
        while(true) {
            try {
                println("Please enter the purchase amount.")
                val purchaseAmountInput = Console.readLine()
                try {
                    val purchaseAmount = purchaseAmountInput.toInt()
                    return validatePurchaseAmount(purchaseAmount)
                } catch (e: NumberFormatException) {
                    println("[ERROR] Invalid input. Please enter a valid number for the purchase amount.")
                }
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    // Ask user to input exactly 6 numbers  comma-separated and they should be between 1 and 45
    fun getWinningNumbers(): List<Int> {
        while(true) {
            try {
                println("Please enter last week's winning numbers.")
                val winningNumbersInput = Console.readLine()
                val winningNumbers = parseWinningNumbers(winningNumbersInput)
                validatedWinningNumbers = validateWinningNumbers(winningNumbers)
                return validatedWinningNumbers
            } catch(e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    // Ask user to input a bonus number different from the previous ones and between 1 and 45
    fun getBonusNumber(): Int {
        while(true) {
            try {
                println("Please enter the bonus number.")
                val bonusNumber = Console.readLine().toInt()
                return validateBonusNumber(validatedWinningNumbers, bonusNumber)
            } catch(e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    companion object{
        // Validates that the purchase amount
        internal fun validatePurchaseAmount(purchaseAmount: Int): Int{
            if (purchaseAmount%1000 != 0)
                throw IllegalArgumentException("[ERROR] Not divisible by 1000")
            if (purchaseAmount <= 0)
                throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0")
            return purchaseAmount
        }

        // Parses a comma-separated string of winning numbers into a list of integers
        internal fun parseWinningNumbers(winningNumbersStr: String): List<Int> {
            val winningNumbers = winningNumbersStr.split(",")
                .map { it.trim() }
                .mapNotNull { it.toIntOrNull() }
            return winningNumbers
        }

        // Validates the list of winning numbers.
        internal fun validateWinningNumbers(winningNumbers: List<Int>): List<Int> {
            if (winningNumbers.size != 6)
                throw IllegalArgumentException("[ERROR] There must be exactly 6 numbers")

            if (winningNumbers.size != winningNumbers.toSet().size)
                throw IllegalArgumentException("[ERROR] All numbers must be unique")

            if (winningNumbers.any { it !in 1..45 })
                throw IllegalArgumentException("[ERROR] All numbers must be between 1 and 45")
            return winningNumbers
        }

        // Validates the bonus number
        fun validateBonusNumber(winningNumbers: List<Int>, bonusNumber: Int): Int {
            if (bonusNumber in winningNumbers)
                throw IllegalArgumentException("[ERROR] Bonus number must be different from other numbers")
            if(bonusNumber !in 1..45)
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45")
            return bonusNumber
        }
    }
}

