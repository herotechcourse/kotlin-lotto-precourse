package lotto.controller

import lotto.validation.BonusNumberValidator
import lotto.view.InputView

object BonusNumberHandler {
    fun readValidated(winningNumbers: List<String>): String {
        while (true) {
            val bonusNumber = InputView.readBonusNumber()
            try {
                return validateAndReturn(bonusNumber, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateAndReturn(bonusNumber: String, winningNumbers: List<String>): String {
        BonusNumberValidator.validate(bonusNumber)
        BonusNumberValidator.validateDuplicateWithWinningNumbers(bonusNumber, winningNumbers)

        return bonusNumber
    }
}
