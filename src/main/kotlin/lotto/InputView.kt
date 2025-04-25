package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputReader(message: String): String {
        println(message)
        val input = Console.readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("[ERROR] Input must be non-empty")
        }

        return input
    }

    companion object {
        fun getPurchaseAmount(input: String): Int {
            if (input.toIntOrNull() == null || input.toInt() <= 0 || input.toInt() % 1000 != 0) {
                throw IllegalArgumentException("[ERROR] Please enter the valid purchase amount.")
            }

            return input.toInt()
        }

        fun getWinningNumbers(input: String): List<Int> {
            val numbers = input.split(',').map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] You must enter exactly 6 unique integers between 1 and 45.") }

            if (numbers.size != 6 || !numbers.all { it in 1..45 } || numbers.distinct().size != numbers.size ) {
                throw IllegalArgumentException("[ERROR] You must enter exactly 6 unique integers between 1 and 45.")
            }

            return numbers
        }

        fun getBonusNumber(input: String): Int {
            if (input.toIntOrNull() == null || input.toInt() !in 1..45)  {
                throw IllegalArgumentException("[ERROR] Bonus number must be an integer between 1 and 45.")
            }

            return input.toInt()
        }
    }
}