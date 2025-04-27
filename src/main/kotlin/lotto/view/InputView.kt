package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return Console.readLine().toInt()
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return Console.readLine()
            .split(",")
            .map { it.trim().toInt() }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return Console.readLine().toInt()
    }
}