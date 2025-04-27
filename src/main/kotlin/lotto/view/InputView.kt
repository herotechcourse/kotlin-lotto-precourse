package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return retryInput {
            val input = Console.readLine()
            input.toIntOrNull()?.takeIf { it > 0 && it % 1000 == 0 }
                ?: throw IllegalArgumentException("[ERROR] Amount must be a multiple of 1,000.")
        }
    }

    fun readWinningNumbers(): Set<Int> {
        println("\nPlease enter last week's winning numbers.")
        return retryInput {
            val input = Console.readLine()
            val numbers = input.split(",").mapNotNull { it.trim().toIntOrNull() }
            if (numbers.size != 6 || numbers.distinct().size != 6 || numbers.any { it !in 1..45 }) {
                throw IllegalArgumentException("[ERROR] Lotto numbers must be between 1 and 45.")
            }
            numbers.toSet()
        }
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        return retryInput {
            val input = Console.readLine()
            val number = input.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Bonus number must be a number between 1 and 45.")
            if (number !in 1..45) {
                throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
            }
            number
        }
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
