package lotto

import lotto.validator.BonusNumberValidator
import lotto.validator.WinningNumbersValidator

data class WinningNumbers(val numbers: List<String>, val bonusNumber: String) {
    init{
        WinningNumbersValidator.validate(numbers)
        BonusNumberValidator.validate(bonusNumber, numbers)
    }

    fun getWinningNumbers(): List<Int> {
        return numbers.map { it.toInt() }
    }

    fun getBonusNumber(): Int {
        return bonusNumber.toInt()
    }
}
