package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): Long {
        println("Please enter the purchase amount.")

        return Console.readLine().toLong()
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")

        return Console.readLine()
            .split(",")
            .map { it.trim().toInt() }
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")

        return Console.readLine().toInt()
    }
}
