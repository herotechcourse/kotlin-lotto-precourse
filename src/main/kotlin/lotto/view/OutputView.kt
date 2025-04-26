package lotto.view

import lotto.support.Message

object OutputView {
    fun printPurchaseAmountPrompt() {
        println(Message.PURCHASE_AMOUNT_PROMPT)
    }
    fun printErrorMessage(message: String?) {
        println(message)
    }
}