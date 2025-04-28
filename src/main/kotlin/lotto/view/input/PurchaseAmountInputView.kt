package lotto.view.input

import camp.nextstep.edu.missionutils.Console

object PurchaseAmountInputView : InputView {
    override fun readInput(): String {
        println("Please enter the purchase amount.")

        return Console.readLine()
    }
}