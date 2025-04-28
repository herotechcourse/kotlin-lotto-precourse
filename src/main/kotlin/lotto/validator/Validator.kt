package lotto.validator

interface Validator {
    fun validatePurchaseAmount(input: String): Int
    fun validateWinningNumbers(input: String): List<Int>
    fun validateBonusNumber(input: String): Int
}
