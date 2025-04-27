package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun purchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val purchaseNumber = Console.readLine().trim()
                if (purchaseNumber.toIntOrNull() == null) {
                    throw IllegalArgumentException("Input must be numbers between 1 and 45")
                }
                if (purchaseNumber.toInt() !in 1..45) {
                    throw IllegalArgumentException("Lotto numbers must be between 1 and 45.")
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