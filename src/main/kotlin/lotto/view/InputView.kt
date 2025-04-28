package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    // Reads the purchase amount from the user
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it % 1000 == 0 }
        // Validate input is a number and divisible by 1000
            ?: throw IllegalArgumentException("[ERROR] Purchase amount must be a number divisible by 1000.")
    }

    // Reads the winning numbers (comma-separated) from the user
    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated).")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid winning number.") }
        // Validate: 6 numbers, no duplicates, all between 1 and 45
        if (numbers.size != 6 || numbers.toSet().size != 6 || numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
        }
        return numbers
    }

    // Reads the bonus number from the user
    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it in 1..45 }
        // Validate bonus number is between 1 and 45
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
    }
}