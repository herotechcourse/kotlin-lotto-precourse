package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Input must be a number.")
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.") }

        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] You must enter exactly 6 numbers.")
        }

        if (numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Duplicate numbers are not allowed.")
        }

        return numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input must be a number.")

        if (winningNumbers.contains(bonus)) {
            throw IllegalArgumentException("[ERROR] Bonus number must not duplicate a winning number.")
        }

        return bonus
    }
}