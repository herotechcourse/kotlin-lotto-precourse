package lotto.ui

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val PURCHASE_AMOUNT_INPUT_MESSAGE = "Please enter the purchase amount."

    fun getPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_INPUT_MESSAGE)
        return Console.readLine()
    }
}