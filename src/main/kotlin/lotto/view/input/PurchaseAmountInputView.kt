package lotto.view.input

import camp.nextstep.edu.missionutils.Console
import lotto.view.validator.NumericValidator

class PurchaseAmountInputView : InputView {
    override fun readInput(): String {
        println("Please enter the purchase amount.")

        return Console.readLine()
    }
}