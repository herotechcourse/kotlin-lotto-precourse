package lotto.views

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int = promptAgain {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val readInput = input.toIntOrNull()

        if (readInput == null || readInput < 0 || readInput % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be positive and divisible by 1000.")
        }

        readInput
    }
    fun readWinningNumbers(): List<Int> = promptAgain {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        val numbers = input.split(",").map { it.trim().toIntOrNull() }

        if (numbers.any { it == null } || numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] There must be exactly 6 valid numbers comma separated")
        }

        val validNumbers = numbers.filterNotNull()

        if (validNumbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Numbers must be unique")
        }

        if (validNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        }

        validNumbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int = promptAgain {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Number must be a valid integer.")

        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }

        if (bonus in winningNumbers) {
            throw IllegalArgumentException( "[ERROR] Bonus number must be different from winning numbers.")
        }

        bonus
    }

    private fun <T> promptAgain(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}