package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.StringParser

class InputView {

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

    private fun readInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }

    companion object {
        private const val READ_PURCHASE_AMOUNT_MESSAGE: String = "Please enter the purchase amount."
        private const val READ_WINNING_NUMBERS_MESSAGE: String = "Please enter last week's winning numbers."

        private const val WINNING_NUMBER_DELIMITER = ","

        private const val INVALID_INPUT_ERROR = "[ERROR] Input value does not exist."
    }

}
