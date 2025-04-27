package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): String {
        println(RequestMessages.AMOUNT)
        return Console.readLine()
    }

    fun readWinningNumbers(): List<String> {
        println(RequestMessages.WINNING_NUMBERS)
        return Console.readLine().split(",").map {it.trim()}
    }

    fun readBonusNumber(): String {
        println(RequestMessages.BONUS_NUMBER)
        return Console.readLine()
    }

    companion object RequestMessages {
        const val AMOUNT = "Please enter the purchase amount."
        const val WINNING_NUMBERS = "\nPlease enter last week's winning numbers."
        const val BONUS_NUMBER = "\nPlease enter the bonus number."
    }
}