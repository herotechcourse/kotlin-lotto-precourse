package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid purchase amount. Please enter a valid number.")
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        try {
            return input.split(",")
                .map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid winning numbers. Please enter valid numbers separated by commas.")
        }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid bonus number. Please enter a valid number.")
        }
    }
}
