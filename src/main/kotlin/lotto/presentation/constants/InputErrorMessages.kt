package lotto.presentation.constants

object InputErrorMessages {
    const val ERROR_AMOUNT_INTEGER = "[ERROR] Amount must be integer."
    const val ERROR_AMOUNT_INVALID = "[ERROR] Amount must be at least 1000 and divisible by 1000."
    const val ERROR_WINNING_NUMBERS_SIZE = "[ERROR] You must enter exactly 6 numbers."
    const val ERROR_DUPLICATE_NUMBERS = "[ERROR] Duplicate numbers are not allowed."
    const val ERROR_NUMBER_RANGE = "[ERROR] Lotto numbers must be between 1 and 45."
    const val ERROR_BONUS_INVALID = "[ERROR] Invalid number."
    const val ERROR_BONUS_RANGE = "[ERROR] Bonus number must be between 1 and 45."
    const val ERROR_BONUS_DUPLICATE = "[ERROR] Bonus number must not be part of the winning numbers."
}
