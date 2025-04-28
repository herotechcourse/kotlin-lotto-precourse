package lotto.ui

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        return validateInputAmount()
    }

    fun readWinningNumbers(): List<Int> {
        return validateWinningNumbers()
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        return validateBonusNumber(winningNumbers)
    }

    fun validateBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("\nPlease enter the bonus number.")
                val input = Console.readLine()
                    .trim()
                    .toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be a digit.")

                require(input in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
                require(input !in winningNumbers) { "[ERROR] Bonus number must not be in winning numbers." }
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("\nPlease enter the winning numbers.")
                val input = Console.readLine()
                    .split(",")
                    .map { it.trim() }
                    .map { it.toIntOrNull() ?: throw IllegalArgumentException( "[ERROR] Winning numbers must be digits") }

                require(input.size == 6) { "[ERROR] Exactly 6 winning numbers must be entered." }
                require(input.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45" }
                require(input.toSet().size == input.size) { "[ERROR] Winning numbers must be unique." }

                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateInputAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine()

                val number = input.toIntOrNull()
                    ?: throw IllegalArgumentException("[ERROR] Input must be a number.")

                require(number % 1000 == 0) { "[ERROR] Purchase amount must be divisible by 1000." }
                return number
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}