package lotto.support

object Message {
    // Error Messages
    const val ERROR_AMOUNT_TOO_SMALL = "[ERROR] Purchase amount must be at least 1,000."
    const val ERROR_AMOUNT_NOT_DIVISIBLE = "[ERROR] Purchase amount must be divisible by 1,000."
    const val ERROR_INPUT_NOT_INT = "[ERROR] Input must be a number."
    const val UNKNOWN_ERROR = "[ERROR] Unknown error occurred."
    const val ERROR_LOTTO_NUMBERS_COUNT = "[ERROR] Lotto must contain exactly 6 numbers."
    const val ERROR_BONUS_RANGE = "[ERROR] Bonus number must be between 1 and 45."
    const val ERROR_WINNER_RANGE = "[ERROR] Winner numbers must be between 1 and 45."
    const val ERROR_WINNING_NUMBERS_COUNT = "[ERROR] Winning numbers must consist of exactly 6 distinct numbers."
    const val ERROR_WINNING_NUMBERS_DUPLICATE = "[ERROR] Winning numbers must not contain duplicates."
    const val ERROR_BONUS_DUPLICATE = "[ERROR] Bonus number must not duplicate any winning number."

    // Prompt Messages
    const val PURCHASE_AMOUNT_PROMPT = "Please enter the purchase amount."
    const val PURCHASED_TICKETS_MESSAGE = "You have purchased %d tickets."
    const val WINNING_TICKET_PROMPT = "Please enter last week's winning numbers."
    const val BONUS_NUMBER_PROMPT = "Please enter the bonus number."
    const val RETURN_RATE_MESSAGE = "Total return rate is %s%%."
    const val RESULT_TITLE = "Winning Statistics"
    const val DRAW_LINE = "---"
    const val NORMAL_MATCH_RESULT_FORMAT = "%s Matches (%s KRW) – %d tickets"
    const val BONUS_MATCH_RESULT_FORMAT = "%s Matches + Bonus Ball (%s KRW) – %d tickets"
}