package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.StringParser

class InputView {

    fun readPurchaseAmount(): Int {
        println(READ_PURCHASE_AMOUNT_MESSAGE)
        val purchaseAmount = readInput()
        return StringParser.parseToInt(purchaseAmount)
    }

    private fun readInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }

    companion object {
        private const val READ_PURCHASE_AMOUNT_MESSAGE: String = "Please enter the purchase amount."

        private const val INVALID_INPUT_ERROR = "[ERROR] Input value does not exist."
    }

}
