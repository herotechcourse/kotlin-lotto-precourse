package lotto.constant

object Constants {

    // Common error prefix
    const val ERROR_PREFIX = "[ERROR] "

    // Money related
    const val ERROR_INVALID_PURCHASE_AMOUNT = "${ERROR_PREFIX}Invalid purchase amount. Must be a positive number and a multiple of 1,000."

    // Lotto number related
    const val ERROR_INVALID_NUMBER_RANGE = "${ERROR_PREFIX}Lotto number must be between 1 and 45."

    // Winning numbers related
    const val ERROR_INVALID_WINNING_NUMBERS = "${ERROR_PREFIX}Invalid winning numbers."
    const val ERROR_DUPLICATE_WINNING_NUMBERS = "${ERROR_PREFIX}Winning numbers must not contain duplicates."
    const val ERROR_WRONG_WINNING_NUMBER_COUNT = "${ERROR_PREFIX}Exactly 6 winning numbers must be entered."

    // Bonus number related
    const val ERROR_DUPLICATE_BONUS_NUMBER = "${ERROR_PREFIX}Bonus number must not duplicate a winning number."

    // InputView related
    const val ERROR_NOT_A_NUMBER = "${ERROR_PREFIX}Input must be a valid number."

    // Profit calculation related
    const val ERROR_INVALID_TOTAL_AMOUNT = "${ERROR_PREFIX}Purchase amount must be greater than 0."
}