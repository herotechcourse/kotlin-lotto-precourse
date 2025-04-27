package lotto.utils

interface InputValidator {
    fun validatePurchaseAmount(purchaseAmountInput: String): Int
    fun validateWinningNumbers(winningNumbersInput: String): List<Int>
}

class InputValidatorImpl : InputValidator {
    override fun validatePurchaseAmount(purchaseAmountInput: String): Int {
        try {
            val purchaseAmount = purchaseAmountInput.toInt()
            require(purchaseAmount > 0) { POSITIVE_INTEGER_ERROR_MESSAGE }
            require(purchaseAmount % DIVISOR == 0) { DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE }
            return purchaseAmount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(POSITIVE_INTEGER_ERROR_MESSAGE)
        }
    }

    override fun validateWinningNumbers(winningNumbersInput: String): List<Int> {
        try {
            val winningNumbers = winningNumbersInput
                .split(",")
                .map {
                    it.toInt()
                }
            require(winningNumbers.size == REQUIRED_COUNT) { WINNING_NUMBERS_COUNTER_ERROR_MESSAGE }
            require(winningNumbers.distinct().size == REQUIRED_COUNT) { WINNING_NUMBERS_UNIQUE_ERROR_MESSAGE }
            return winningNumbers
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(WINNING_NUMBERS_ERROR_MESSAGE)
        }
    }

    companion object {
        private const val POSITIVE_INTEGER_ERROR_MESSAGE =
            "Amount must be an integer number greater than or equal 1000."
        private const val DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE = "Amount must be divisible by 1000."
        private const val DIVISOR = 1000
        private const val WINNING_NUMBERS_ERROR_MESSAGE = "Winning numbers must contain integer numbers only."
        private const val REQUIRED_COUNT = 6
        private const val WINNING_NUMBERS_COUNTER_ERROR_MESSAGE = "Winning numbers must contain exactly 6 numbers."
        private const val WINNING_NUMBERS_UNIQUE_ERROR_MESSAGE = "Winning numbers must be unique."
    }
}