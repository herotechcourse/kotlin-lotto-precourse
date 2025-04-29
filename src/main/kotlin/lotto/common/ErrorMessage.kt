package lotto.common

object ErrorMessages {
    const val INVALID_PURCHASE_AMOUNT = "[ERROR] Amount must be a positive number divisible by 1,000."
    const val INVALID_WINNING_COUNT = "[ERROR] Please enter exactly 6 valid numbers."
    const val DUPLICATE_WINNING_NUMBERS = "[ERROR] Winning numbers must be unique."
    const val OUT_OF_RANGE_WINNING_NUMBER = "[ERROR] Numbers must be between 1 and 45."
    const val INVALID_BONUS_NUMBER = "[ERROR] Bonus number must be a valid integer."
    const val BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] Bonus number must be between 1 and 45."
    const val BONUS_NUMBER_DUPLICATE = "[ERROR] Bonus number must not be part of the winning numbers."
    const val LOTTO_SIZE_MUST_BE_SIX = "[ERROR] Lotto must contain exactly 6 numbers."
    const val LOTTO_NUMBERS_MUST_BE_UNIQUE = "[ERROR] Lotto numbers must be unique."
    const val LOTTO_NUMBERS_MUST_BE_IN_RANGE = "[ERROR] Lotto numbers must be between 1 and 45."
}