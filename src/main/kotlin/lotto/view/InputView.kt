package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = readLineOrThrow()
        return parseIntOrThrow(input)
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = readLineOrThrow()
        return parseCommaSeparatedNumbers(input)
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = readLineOrThrow()
        return parseIntOrThrow(input)
    }

    private fun parseIntOrThrow(input: String): Int {
        try {
            val number = input.toInt()
            if (number <= 0) {
                throw IllegalArgumentException("[ERROR] Please enter a valid number.")
            }
            return number
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }

    private fun parseCommaSeparatedNumbers(input: String): List<Int> {
        try {
            return input.split(",").map { it.trim().toInt() }
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.")
        }
    }

    private fun readLineOrThrow(): String {
        val input = Console.readLine()
        if (input.isBlank()) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
        return input
    }
}