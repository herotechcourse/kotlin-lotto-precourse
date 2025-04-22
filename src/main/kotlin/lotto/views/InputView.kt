package lotto.views

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int = retryInput {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull()

        if (amount == null || amount <= 0 || amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a positive number divisible by 1,000.")
        }

        amount
    }

    fun readWinningNumbers(): List<Int> = retryInput {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() }

        if (numbers.any { it == null } || numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Please enter exactly 6 valid numbers.")
        }

        val validNumbers = numbers.filterNotNull()

        if (validNumbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be unique.")
        }

        if (validNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        }

        validNumbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int = retryInput {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a valid integer.")

        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }

        if (bonus in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be part of the winning numbers.")
        }

        bonus
    }

    private fun <T> retryInput(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}