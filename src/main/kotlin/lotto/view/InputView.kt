// this file represents the user input / UI helper

package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Must enter a valid number.")
        if (amount % 1000 != 0) throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return input.split(",").map { it.trim().toInt() }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return Console.readLine().toInt()
    }
}
