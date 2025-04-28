package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid purchase amount. Please enter a numeric value.")
        }
    }

    fun getWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        try {
            val winningNums = Console.readLine()
            return winningNums.split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid winning numbers. Please enter valid numeric values.")
        }
    }

    fun getBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        try {
            return Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Invalid bonus number. Please enter a valid numeric value.")
        }
    }
}