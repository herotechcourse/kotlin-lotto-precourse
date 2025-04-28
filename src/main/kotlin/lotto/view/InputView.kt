package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validator.Validator

/**
 * Handles all console input for the Lotto game.
 */
object InputView {
    class InputView(private val validator: Validator) {

        /** Reads and validates the purchase amount */
        fun readPurchaseAmount(): Int {
            val raw = Console.readLine()
            return validator.validatePurchaseAmount(raw)
        }

        /** Reads and validates the winning numbers */
        fun readWinningNumbers(): List<Int> {
            val raw = Console.readLine()
            return validator.validateWinningNumbers(raw)
        }

        /** Reads and validates the bonus number */
        fun readBonusNumber(): Int {
            val raw = Console.readLine()
            return validator.validateBonusNumber(raw)
        }
    }
}
