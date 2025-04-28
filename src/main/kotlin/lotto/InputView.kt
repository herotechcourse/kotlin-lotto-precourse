package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount.")

            try {
                val input = Console.readLine()?.trim()?.toInt()
                    ?: throw IllegalArgumentException("[ERROR] Input cannot be null")

                println()

                return input
            } catch (e: NumberFormatException) {
                println("[ERROR] Please enter a valid integer\n")
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            println("Please enter last week's winning numbers.")

            try {
                val input = Console.readLine()?.trim() ?: throw IllegalArgumentException("[ERROR] Input cannot be null")

                val numbers = input.split(",")
                    .mapNotNull { it.trim().toIntOrNull() }
                    .toList()

                if (numbers.size != 6 || numbers.size != numbers.distinct().size) {
                    throw IllegalArgumentException("[ERROR] You must enter exactly 6, non duplicate numbers.")
                }

                println()

                return numbers
            } catch (e: IllegalArgumentException) {
                println("[ERROR] Please enter a valid 6 integer\n")
            }
        }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println("Please enter the bonus number.")

            try {
                val input = Console.readLine()?.trim()?.toInt()
                    ?: throw IllegalArgumentException("[ERROR] Input cannot be null")

                if (input < 1 || input > 45 || input in winningNumbers) {
                    throw IllegalArgumentException("[ERROR] bonus number must be between 1 and 45, not in winningNumbers.")
                }

                println()

                return input
            } catch (e: IllegalArgumentException) {
                println("[ERROR] Please enter valid number\n")
            }
        }
    }
}