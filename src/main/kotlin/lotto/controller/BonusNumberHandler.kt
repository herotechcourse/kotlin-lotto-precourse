package lotto.controller

import lotto.validation.BonusNumberValidator
import lotto.view.InputView

object BonusNumberHandler {

    fun readValidatedBonusNumber(winningNumbers: List<String>): String {
        while (true) {
            val bonusNumber = InputView.readBonusNumber()
            try {
                return handleBonusNumber(bonusNumber, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun handleBonusNumber(bonusNumber: String, winningNumbers: List<String>): String {
        BonusNumberValidator.validate(bonusNumber)
        BonusNumberValidator.validateDuplicateWithWinningNumbers(bonusNumber, winningNumbers)

        return bonusNumber
    }
}