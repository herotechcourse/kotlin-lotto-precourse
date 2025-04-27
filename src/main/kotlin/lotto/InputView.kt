package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun purchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val purchaseNumber = Console.readLine().trim()
                if (purchaseNumber.toIntOrNull() == null) {
                    throw IllegalArgumentException("Input must be a number")
                }
                if (purchaseNumber.toIntOrNull()!! < 1000) {
                    throw IllegalArgumentException("Purchase amount must be more than 1000")
                }
                return purchaseNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun winningNum(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
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
                println("Please enter the bonus number.")
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