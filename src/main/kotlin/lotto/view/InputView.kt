package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val PURCHASE_PROMPT = "Please enter the purchase amount."
    private const val WINNING_NUMBERS_PROMPT = "Please enter the winning numbers (comma-separated)."
    private const val BONUS_NUMBER_PROMPT = "Please enter the bonus number."

    fun readPurchaseAmount(): String {
        println(PURCHASE_PROMPT)
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println(WINNING_NUMBERS_PROMPT)
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println()
        println(BONUS_NUMBER_PROMPT)
        return Console.readLine()
    }
}
