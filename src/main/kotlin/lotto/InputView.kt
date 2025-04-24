package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return input.toInt()
    }

    fun readWinningNumbers(): Int {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return input.toInt()
    }

    fun readBonusNumber(winningNumbers: Lotto): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return input.toInt()
    }
}