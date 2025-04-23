package lotto.view.input

import camp.nextstep.edu.missionutils.Console
import lotto.view.validator.NumericValidator

class PurchaseAmountInputView : InputView {
    override fun readInput(): Int {
        println("Input purchase amount:")

        val purchaseAmount = Console.readLine()
        NumericValidator.validate(purchaseAmount)

        return purchaseAmount.toInt()
    }
}