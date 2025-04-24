package lotto.validation

class BonusNumberValidator(private val winningNumberValidator: WinningNumberValidator) {

    fun validateBonusNumber(input: String): Int {
        // Validate if the input is not blank
        winningNumberValidator.isNotBlank(input)

        // Validate if the input is a valid number
        val number =  winningNumberValidator.validateIsNumber(input)

        RangeValidator.validateInRange(number)
        return number

    }
}