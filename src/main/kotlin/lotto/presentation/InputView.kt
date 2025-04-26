package lotto.presentation

import camp.nextstep.edu.missionutils.Console

interface InputView {
    fun promptInputForPurchaseAmount(): String
}

class InputViewImpl : InputView {
    override fun promptInputForPurchaseAmount(): String {
        println(PURCHASE_AMOUNT_PROMPT)
        return Console.readLine()
    }

    companion object {
        private const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
    }

}
