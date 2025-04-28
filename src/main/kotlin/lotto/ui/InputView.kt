package lotto.ui

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val PURCHASE_AMOUNT_INPUT_MESSAGE = "Please enter the purchase amount."
    private const val WINNING_NUMBERS_INPUT_MESSAGE = "Please enter last week's winning numbers."
    private const val BONUS_NUMBER_INPUT_MESSAGE = "Please enter the bonus number."

    fun getPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun getWinningNumbers(): String {
        println(WINNING_NUMBERS_INPUT_MESSAGE)
        return Console.readLine()
    }

    fun getBonusNumber(): String {
        println(BONUS_NUMBER_INPUT_MESSAGE)
        return Console.readLine()
    }
}