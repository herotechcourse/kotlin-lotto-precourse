package lotto.support

object Message {
    // Error Messages
    const val ERROR_AMOUNT_TOO_SMALL = "[ERROR] Purchase amount must be at least 1,000."
    const val ERROR_AMOUNT_NOT_DIVISIBLE = "[ERROR] Purchase amount must be divisible by 1,000."
    const val ERROR_INPUT_NOT_INT = "[ERROR] Input must be a number."
    const val UNKNOWN_ERROR = "[ERROR] Unknown error occurred."
    const val ERROR_LOTTO_NUMBERS_COUNT = "[ERROR] Lotto must contain exactly 6 numbers."
    // Prompt Messages
    const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
    const val PURCHASED_TICKETS_MESSAGE = "You have purchased %d tickets."
}