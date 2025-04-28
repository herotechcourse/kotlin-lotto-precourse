package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readInt()
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return readListOfInts()
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return readInt()
    }

    private fun readInt(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readListOfInts(): List<Int> {
        while (true) {
            try {
                val input = Console.readLine()
                val numbers = input.split(",")
                    .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.") }
                println()
                return numbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
