package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validator.Validator

/**
 * Handles all console input for the Lotto game.
 */
class InputView(private val validator: Validator): IInputView {

    /** Reads and validates the purchase amount */
    override fun readPurchaseAmount(): Int {
        val raw = Console.readLine()
        return validator.validatePurchaseAmount(raw)
    }

    /** Reads and validates the winning numbers */
    override fun readWinningNumbers(): List<Int> {
        val raw = Console.readLine()
        return validator.validateWinningNumbers(raw)
    }

    /** Reads and validates the bonus number */
    override fun readBonusNumber(): Int {
        val raw = Console.readLine()
        return validator.validateBonusNumber(raw)
    }
}
