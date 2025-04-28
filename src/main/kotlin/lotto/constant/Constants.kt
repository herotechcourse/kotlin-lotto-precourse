package lotto.constant

object Constants {
    // Money related
    const val ERROR_MINIMUM_PURCHASE_AMOUNT = "[ERROR] Invalid purchase amount. Must be at least ₩1,000."
    const val ERROR_MULTIPLE_OF_TICKET_PRICE = "[ERROR] Purchase amount must be a multiple of ₩1,000."

    // Lotto number related
    const val ERROR_LOTTO_NUMBER_RANGE = "[ERROR] Lotto number must be between 1 and 45."

    // Winning numbers related
    const val ERROR_DUPLICATE_LOTTO_NUMBER = "[ERROR] Lotto numbers must not contain duplicates."
    const val ERROR_INVALID_LOTTO_SIZE = "[ERROR] Lotto must contain exactly 6 numbers."

    // Bonus number related
    const val ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] Bonus number must not duplicate a winning number."

    // InputView related
    const val ERROR_INVALID_INPUT_NUMBER = "[ERROR] Input must be a number."
    const val ERROR_NOT_SIX_WINNING_NUMBERS = "[ERROR] You must enter exactly 6 numbers."
    const val ERROR_DUPLICATE_WINNING_NUMBER = "[ERROR] Duplicate numbers are not allowed."

    // Profit calculation related
    const val ERROR_INVALID_PURCHASE_AMOUNT = "[ERROR] Purchase amount must be greater than 0."

    // Lotto basic constants
    const val LOTTO_NUMBER_MIN = 1
    const val LOTTO_NUMBER_MAX = 45
    const val LOTTO_NUMBERS_COUNT = 6
    const val TICKET_PRICE = 1000
}