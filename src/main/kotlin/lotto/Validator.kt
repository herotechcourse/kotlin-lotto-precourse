package lotto

object Validator {
    private const val ERROR_INVALID_AMOUNT = "[ERROR] Purchase amount must be a positive number and divisible by 1000."
    private const val ERROR_INVALID_WINNING_NUMBERS_COUNT = "[ERROR] Exactly 6 winning numbers must be provided."
    private const val ERROR_DUPLICATE_WINNING_NUMBERS = "[ERROR] Winning numbers must be unique."
    private const val ERROR_NUMBER_OUT_OF_RANGE = "[ERROR] Numbers must be between $LOTTO_NUMBER_MIN and $LOTTO_NUMBER_MAX."
    private const val ERROR_BONUS_DUPLICATE = "[ERROR] Bonus number must not be one of the winning numbers."

    fun validateAmount(amount: Int) {
        if (amount <= 0 || amount % LOTTO_UNIT_PRICE != 0) {
            throw IllegalArgumentException(ERROR_INVALID_AMOUNT)
        }
    }

    fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException(ERROR_INVALID_WINNING_NUMBERS_COUNT)
        }
        if (numbers.toSet().size != LOTTO_NUMBER_COUNT) {
            throw IllegalArgumentException(ERROR_DUPLICATE_WINNING_NUMBERS)
        }
        if (numbers.any { it !in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) {
            throw IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE)
        }
    }

    fun validateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        if (bonus !in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) {
            throw IllegalArgumentException(ERROR_NUMBER_OUT_OF_RANGE)
        }
        if (bonus in winningNumbers) {
            throw IllegalArgumentException(ERROR_BONUS_DUPLICATE)
        }
    }

}