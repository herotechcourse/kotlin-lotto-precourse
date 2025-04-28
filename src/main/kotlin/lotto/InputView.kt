package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
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
                if (winningNumbers.size != 6) {
                    throw IllegalArgumentException("Exactly 6 numbers must be entered.")
                }
                if (winningNumbers.toSet().size != 6) {
                    throw IllegalArgumentException("Numbers must not be duplicated.")
                }
                if (winningNumbers.any { it !in 1..45 }) {
                    throw IllegalArgumentException("Numbers must be between 1 and 45.")
                }
                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }

    }

    fun bonusNum(): Int {
        while (true) {
            try {
                println("\nPlease enter the bonus number.")
                val input = Console.readLine().trim()
                val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("Input must be a number.")
                if (bonusNumber !in 1..45) {
                    throw IllegalArgumentException("Bonus number must be between 1 and 45.")
                }
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }
}