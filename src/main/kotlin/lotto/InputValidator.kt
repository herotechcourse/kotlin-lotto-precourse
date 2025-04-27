package lotto

interface InputValidator {
    fun validatePurchaseAmount(purchaseAmountInput: String): Int
    fun validateWinningNumbers(winningNumbersInput: String): List<Int>
    fun validateBonusNumber(bonusNumberInput: String): Int
}

class InputValidatorImpl : InputValidator {
    override fun validatePurchaseAmount(purchaseAmountInput: String): Int {
        try {
            val purchaseAmount = purchaseAmountInput.toInt()
            require(purchaseAmount > 0) { PURCHASE_AMOUNT_POSITIVE_INTEGER_ERROR_MESSAGE }
            require(purchaseAmount % DIVISOR == 0) { PURCHASE_AMOUNT_DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE }
            return purchaseAmount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(PURCHASE_AMOUNT_POSITIVE_INTEGER_ERROR_MESSAGE)
        }
    }

    override fun validateWinningNumbers(winningNumbersInput: String): List<Int> {
        try {
            val winningNumbers = winningNumbersInput
                .split(",")
                .map {
                    it.toInt()
                }
            require(winningNumbers.size == REQUIRED_COUNT) { WINNING_NUMBERS_ERROR_MESSAGE }
            require(winningNumbers.all { it in LOWER_RANGE..UPPER_RANGE }) { WINNING_NUMBERS_RANGE_ERROR_MESSAGE }
            require(winningNumbers.distinct().size == REQUIRED_COUNT) { WINNING_NUMBERS_UNIQUE_ERROR_MESSAGE }
            return winningNumbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(WINNING_NUMBERS_ERROR_MESSAGE)
        }
    }

    override fun validateBonusNumber(bonusNumberInput: String): Int {
        try {
            val bonusNumber = bonusNumberInput.toInt()
            require(bonusNumber in LOWER_RANGE..UPPER_RANGE) { BONUS_NUMBER_ERROR_MESSAGE }
            return bonusNumber
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val PURCHASE_AMOUNT_POSITIVE_INTEGER_ERROR_MESSAGE =
            "Purchase amount must be an integer number greater than or equal 1000."
        private const val PURCHASE_AMOUNT_DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE =
            "Purchase amount must be divisible by 1000."
        private const val DIVISOR = 1000
        private const val LOWER_RANGE = 1
        private const val UPPER_RANGE = 45
        private const val WINNING_NUMBERS_ERROR_MESSAGE = "Winning numbers must contain exactly 6 integer numbers separated by comma."
        private const val REQUIRED_COUNT = 6
        private const val WINNING_NUMBERS_UNIQUE_ERROR_MESSAGE = "Winning numbers must be unique."
        private const val WINNING_NUMBERS_RANGE_ERROR_MESSAGE = "Winning numbers must be between 1 and 45."
        private const val BONUS_NUMBER_ERROR_MESSAGE = "Bonus number must be a positive integer between 1 and 45."
    }
}