package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validator.InputValidator

object InputView {

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine().trim()
        return InputValidator.validateAmount(input)
    }
}
