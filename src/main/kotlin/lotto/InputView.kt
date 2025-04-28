package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readInt()
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return readNumbers()
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return readInt()
    }

    private fun readInt(): Int {
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
    }

    private fun readNumbers(): List<Int> {
        val input = Console.readLine()
        return input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.") }
            .also {
                if (it.size != 6) {
                    throw IllegalArgumentException("[ERROR] Must enter exactly 6 numbers.")
                }
            }
    }
}
