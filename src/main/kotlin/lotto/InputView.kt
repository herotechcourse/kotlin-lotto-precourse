package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): String {
        println(PROMPT_PURCHASE_AMOUNT)
        return Console.readLine()
    }

    fun readWinningNumber(): String {
        println(PROMPT_WINNING_NUMBERS)
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println(PROMPT_BONUS_NUMBER)
        return Console.readLine()
    }

    companion object {
        private const val PROMPT_PURCHASE_AMOUNT = "Please enter the purchase amount."
        private const val PROMPT_WINNING_NUMBERS = "\nPlease enter last week's winning numbers."
        private const val PROMPT_BONUS_NUMBER = "\nPlease enter the bonus number."
    }
}