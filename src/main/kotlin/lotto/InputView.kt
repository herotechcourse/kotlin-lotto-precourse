package lotto

import camp.nextstep.edu.missionutils.Console

private const val AMOUNT_REQUEST_MESSAGE = "Please enter the purchase amount."
private const val WINNING_NUMBERS_REQUEST_MESSAGE = "\nPlease enter last week's winning numbers."
private const val BONUS_NUMBER_REQUEST_MESSAGE = "\nPlease enter the bonus number."

class InputView {
    fun readPurchaseAmount(): String {
        println(AMOUNT_REQUEST_MESSAGE)
        return Console.readLine()
    }

    fun readWinningNumbers(): List<String> {
        println(WINNING_NUMBERS_REQUEST_MESSAGE)
        return Console.readLine().split(",").map { it.trim() }
    }

    fun readBonusNumber(): String {
        println(BONUS_NUMBER_REQUEST_MESSAGE)
        return Console.readLine()
    }
}