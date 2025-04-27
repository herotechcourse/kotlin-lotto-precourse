package lotto.views

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): String {
        println("Please enter the purchase amount.")
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println("Please enter last week's winning numbers.")
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println("Please enter the bonus number.")
        return Console.readLine()
    }
}