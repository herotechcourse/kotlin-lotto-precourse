package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount:")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers:")
        val input = Console.readLine()
        return input.split(",").map {
            it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid number format.")
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number:")
        val input = Console.readLine()
        val bonusNumber = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        return bonusNumber
    }
}