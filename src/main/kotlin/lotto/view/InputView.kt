package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a multiple of 1,000.")
        }
        println()
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated).")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number.") }
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] You must enter exactly 6 numbers.")
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Numbers must be unique.")
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        }
        println()
        return numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Invalid bonus number.")
        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (bonus in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
        }
        println()
        return bonus
    }
}
