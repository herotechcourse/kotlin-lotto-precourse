package lotto.common

object ErrorMessages {
    private const val ERROR_PREFIX = "[ERROR]"

    // Parse
    const val INVALID_INPUT_NUMBER = "$ERROR_PREFIX Input must be an integer"

    // Lotto
    const val INVALID_LOTTO_NUMBERS_ITEM = "$ERROR_PREFIX Purchase amount must be integer"
    const val INVALID_LOTTO_NUMBERS_TYPE = "Lotto must not be empty."
    const val INVALID_LOTTO_NUMBERS_SIZE = "Lotto must contain exactly 6 numbers."
    const val INVALID_LOTTO_NUMBERS_UNIT = "Lotto numbers must be between 1 and 45."

    // Money
    const val INVALID_PURCHASE_AMOUNT_TYPE = "$ERROR_PREFIX Purchase amount must be integer"
    const val INVALID_PURCHASE_AMOUNT_UNIT = "$ERROR_PREFIX Purchase amount must be between 1000 and 2147483647"

    // Prize
    const val INVALID_MATCH_COUNT_UNIT = "$ERROR_PREFIX Match Count must be greater than or equal to 0"

    // Winner
    const val INVALID_WINNING_NUMBERS_TYPE = "$ERROR_PREFIX Winning numbers must be non-empty"
    const val INVALID_WINNING_NUMBERS_SIZE = "$ERROR_PREFIX Winning numbers must be 6 numbers"
    const val INVALID_WINNING_NUMBERS_UNIT = "$ERROR_PREFIX Winning numbers must be between 1 and 45"
    const val INVALID_WINNING_NUMBERS_ITEM = "$ERROR_PREFIX Winning numbers must not be duplicates"
    const val INVALID_BONUS_NUMBER_UNIT = "$ERROR_PREFIX Bonus number must be between 1 and 45"
    const val INVALID_BONUS_NUMBER_ITEM = "$ERROR_PREFIX Bonus number should not include winning number"
}