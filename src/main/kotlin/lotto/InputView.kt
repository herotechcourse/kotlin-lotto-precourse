package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readPurchaseAmount(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println("Please enter last week's winning numbers.")
        return Console.readLine()
    }
}
