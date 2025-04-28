package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): String {
        println("Please enter the purchase amount:")
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println("Enter the winning numbers:")
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println("Enter the bonus number:")
        return Console.readLine()
    }

}