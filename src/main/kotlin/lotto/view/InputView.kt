package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private fun prompt(message: String): String {
        println(message)
        return Console.readLine()
    }

    fun readPurchaseAmount(): String = prompt("Please enter the purchase amount.")

    fun readWinnerLotto(): String = prompt("Please enter last week's winning numbers.")

    fun readBonusNumber(): String = prompt("Please enter the bonus number.")

}