package lotto.constants

object ErrorMessageConstants {
    const val ERROR_MESSAGE_EMPTY_VALUE = "[ERROR] Input must not contain empty value"
    const val ERROR_MESSAGE_INVALID_NUMBER = "[ERROR] Invalid number entered for %s"
    const val ERROR_MESSAGE_INVALID_BONUS_NUMBER_LIMIT = "[ERROR] Bonus Number should be a between 1 and 45"
    const val ERROR_MESSAGE_BONUS_NUMBER_IN_LOTTO = "[ERROR] Bonus Number should not be in Lotto numbers"
    const val ERROR_MESSAGE_LOTTO_LENGTH_IS_NOT_6 = "[ERROR] Lotto must contain exactly 6 numbers."
    const val ERROR_MESSAGE_LOTTO_NUMBER_NOT_UNIQUE = "[ERROR] Lotto numbers must be unique."
    const val ERROR_MESSAGE_INVALID_LOTTO_LIMIT = "[ERROR] Lotto numbers must be between 1 and 45."
    const val ERROR_MESSAGE_INVALID_AMOUNT = "[ERROR] Amount must be a multiple of 1000"
}