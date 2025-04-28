package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    private lateinit var lastWinningNumbers: List<Int>

    fun purchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readAndValidateAmount()
    }

    private fun readAndValidateAmount(): Int {
        try {
            val input = Console.readLine().trim()
            val amount = input.toIntOrNull() ?: throw IllegalArgumentException("Input must be a number.")
            validateAmount(amount)
            return amount
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
            return readAndValidateAmount()
        }
    }

    private fun validateAmount(amount: Int) {
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("Purchase amount must be divisible by 1000.")
        }
        if (amount <= 0) {
            throw IllegalArgumentException("Purchase amount must be greater than 0.")
        }
    }

    fun winningNum(): List<Int> {
        while (true) {
            try {
                println("\nPlease enter last week's winning numbers.")
                val input = Console.readLine().trim()
                val winningNumbers = input.split(",")
                    .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("All inputs must be numbers.") }
                validateWinningNumbers(winningNumbers)
                lastWinningNumbers = winningNumbers  // 당첨 번호 저장
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("Exactly 6 numbers must be entered.")
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException("Numbers must not be duplicated.")
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("Numbers must be between 1 and 45.")
        }
    }

    fun bonusNum(): Int {
        while (true) {
            try {
                println("\nPlease enter the bonus number.")
                val input = Console.readLine().trim()
                val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("Input must be a number.")
                validateBonusNumber(bonusNumber)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    private fun validateBonusNumber(number: Int) {
        if (number !in 1..45) {
            throw IllegalArgumentException("Bonus number must be between 1 and 45.")
        }
        if (::lastWinningNumbers.isInitialized && number in lastWinningNumbers) {
            throw IllegalArgumentException("Bonus number cannot be one of the winning numbers.")
        }
    }
}