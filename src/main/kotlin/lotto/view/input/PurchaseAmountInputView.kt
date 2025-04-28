package lotto.view.input

import camp.nextstep.edu.missionutils.Console
import lotto.view.validator.NumericValidator

class PurchaseAmountInputView : InputView {
    override fun readInput(): Int {
        println("Please enter the purchase amount.")

        val purchaseAmount = Console.readLine()
        NumericValidator.validate(purchaseAmount)

        return purchaseAmount.toInt()
    }
}