package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validator.IInputValidator

/**
 * Handles all console input for the Lotto game.
 */
class InputView(private val IInputValidator: IInputValidator): IInputView {

    /** Reads and validates the purchase amount */
    override fun readPurchaseAmount(): Int {
        val raw = Console.readLine()
        return IInputValidator.validatePurchaseAmount(raw)
    }

    /** Reads and validates the winning numbers */
    override fun readWinningNumbers(): List<Int> {
        val raw = Console.readLine()
        return IInputValidator.validateWinningNumbers(raw)
    }

    /** Reads and validates the bonus number */
    override fun readBonusNumber(): Int {
        val raw = Console.readLine()
        return IInputValidator.validateBonusNumber(raw)
    }
}
