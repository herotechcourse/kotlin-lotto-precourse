package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validator.IInputValidator
import lotto.validator.InputValidator

class InputView(
    private val validator: IInputValidator = InputValidator()
) : IInputView {

    override fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val raw = Console.readLine()
        return validator.validatePurchaseAmount(raw)
    }

    override fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers (comma-separated).")
        val raw = Console.readLine()
        return validator.validateWinningNumbers(raw)
    }

    override fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val raw = Console.readLine()
        return validator.validateBonusNumber(raw)
    }
}
