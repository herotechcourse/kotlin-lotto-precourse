package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }

    fun readWinningNumber(): String {
        println("\nPlease enter last week's winning numbers.")
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println("\nPlease enter the bonus number.")
        return Console.readLine()
    }
}