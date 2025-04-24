package lotto

import lotto.Consts.ERROR_PREFIX

class Validator {

    fun validateStringToInt(stringValue: String): Int {
        return stringValue.toIntOrNull()
            ?: throw IllegalArgumentException("$ERROR_PREFIX Non-numeric '$stringValue' is not allowed.")
    }

    fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>): Int {
        return validateStringToInt(bonusNumber).apply {
            validateDuplicatedNumber(this, winningNumbers)
        }
    }

    private fun validateDuplicatedNumber(number: Int, numbers: List<Int>) {
        require(number !in numbers) {
            "$ERROR_PREFIX Bonus number must not duplicate with winning numbers."
        }
    }
}
