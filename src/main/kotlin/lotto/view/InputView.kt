package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.StringParser

object InputView {

    private const val READ_PURCHASE_AMOUNT_MESSAGE: String = "Please enter the purchase amount."
    private const val READ_WINNING_NUMBERS_MESSAGE: String = "Please enter last week's winning numbers."
    private const val READ_BONUS_NUMBER_MESSAGE: String = "Please enter the bonus number."

    private const val WINNING_NUMBER_DELIMITER = ","

    private const val INVALID_INPUT_ERROR = "[ERROR] Input value does not exist."

    fun readPurchaseAmount(): Int {
        println(READ_PURCHASE_AMOUNT_MESSAGE)
        val purchaseAmount = readInput()
        return StringParser.parseToInt(purchaseAmount)
    }

    fun readWinningNumbers(): List<Int> {
        println(READ_WINNING_NUMBERS_MESSAGE)
        val winningNumbers = readInput()
        return StringParser.parseByDelimiter(winningNumbers, WINNING_NUMBER_DELIMITER)
    }

    fun readBonusNumber(): Int {
        println(READ_BONUS_NUMBER_MESSAGE)
        val purchaseAmount = readInput()
        return StringParser.parseToInt(purchaseAmount)
    }

    private fun readInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }
}
