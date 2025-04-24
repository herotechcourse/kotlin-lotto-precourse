package lotto

class Validator {

    fun validateStringToInt(stringValue: String): Int {
        return stringValue.toIntOrNull()
            ?: throw IllegalArgumentException("Non-numeric '$stringValue' is not allowed.")
    }

    fun validateBonusNumber(bonusNumber: String, winningNumbers: List<Int>): Int {
        return validateStringToInt(bonusNumber).apply {
            validateDuplicatedNumber(this, winningNumbers)
        }
    }

    private fun validateDuplicatedNumber(number: Int, numbers: List<Int>) {
        require(number !in numbers) {
            "Bonus number must not duplicate with winning numbers."
        }
    }
}
