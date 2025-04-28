package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine()
                val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

                if (amount <= 0) {
                    throw IllegalArgumentException("[ERROR] Amount must be positive.")
                }
                if (amount % 1000 != 0) {
                    throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
                }
                return amount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val input = Console.readLine()
                val numbers = input.split(",")
                    .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter valid numbers.") }

                if (numbers.size != 6) {
                    throw IllegalArgumentException("[ERROR] Exactly 6 numbers must be entered.")
                }
                if (numbers.toSet().size != 6) {
                    throw IllegalArgumentException("[ERROR] Duplicate numbers are not allowed.")
                }
                if (numbers.any { it !in 1..45 }) {
                    throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
                }
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val input = Console.readLine()
                val bonusNumber = input.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

                if (bonusNumber !in 1..45) {
                    throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
                }
                if (bonusNumber in winningNumbers) {
                    throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
                }
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
