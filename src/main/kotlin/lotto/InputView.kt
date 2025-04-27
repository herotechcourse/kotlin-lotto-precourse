package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")

        try {
            val input = Console.readLine()?.trim()?.toInt() ?: throw IllegalArgumentException("Invalid input: Input cannot be null")
            return input
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input: Please enter a valid integer")
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")

        val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("Invalid input: Input cannot be null")

        val numbers = input.split(",")
            .mapNotNull { it.trim().toIntOrNull() }
            .toList()

        if (numbers.size != 6 || numbers.size != numbers.distinct().size) {
            throw IllegalArgumentException("You must enter exactly 6, non duplicate numbers.")
        }

        return numbers
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")

        try {
            val input = Console.readLine()?.trim()?.toInt() ?: throw IllegalArgumentException("Invalid input: Input cannot be null")
            if (input < 1 || input > 45 || input in winningNumbers) {
                throw IllegalArgumentException("Invalid input: bonus number must be between 1 and 45, not in winningNumbers.")
            }
            return input
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input: Please enter a valid integer")
        }
    }
}