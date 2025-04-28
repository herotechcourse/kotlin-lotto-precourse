package lotto.view

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

object InputView {
    private const val DELIMITER: String = ","
    private const val PURCHASE_AMOUNT_MESSAGE: String = "Please enter the purchase amount."
    private const val WINNING_NUMBER_MESSAGE: String = "Please enter last week's winning numbers."

    fun readPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_MESSAGE)

        val purchaseAmount = Console.readLine().trim()

        return purchaseAmount
    }

    fun readWinningNumbers(): List<String> {
        println(WINNING_NUMBER_MESSAGE)

        val input = Console.readLine()
        val winningNumbers = input.split(DELIMITER).map { it.trim() }

        return winningNumbers
    }
}