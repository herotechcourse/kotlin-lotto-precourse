package lotto.utils

object Constant {
    // Lotto Game Constants
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
    const val LOTTO_SIZE = 6
    const val LOTTO_COST = 1000

    const val FIRST_PRICE = 2_000_000_000
    const val SECOND_PRICE = 30_000_000
    const val THIRD_PRICE = 1_500_000
    const val FOURTH_PRICE = 50_000
    const val FIFTH_PRICE = 5_000

    const val FIRST_MATCH_COUNT = 6
    const val SECOND_MATCH_COUNT = 5
    const val THIRD_MATCH_COUNT = 5
    const val FOURTH_MATCH_COUNT = 4
    const val FIFTH_MATCH_COUNT = 3

    // Guide Message
    const val PURCHASE_AMOUNT_MESSAGE = "Please enter the purchase amount."
    const val LOTTO_QUANTITY_MESSAGE = "You have purchased %d tickets."
    const val LOTTO_WINNING_NUMBER_MESSAGE = "Please enter last week's winning numbers."
    const val BONUS_NUMBER_MESSAGE = "Please enter the bonus number."
    const val WINNING_STATISTICS_HEADER_MESSAGE = "Winning Statistics\n---"
    const val MATCH_PRIZE_MESSAGE = "%d Matches (%s KRW) – %d tickets"
    const val MATCH_PRIZE_BONUS_MESSAGE = "%d Matches + Bonus Ball (%s KRW) – %d tickets"
    const val PRICE_RATE_MESSAGE = "Total return rate is %.1f%%."

    // Exception
    const val LOTTO_SIZE_ERROR_MESSAGE = "[ERROR] Lotto must contain exactly 6 numbers"
    const val PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE = "[ERROR] Invalid purchase amount input"
    const val AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] The amount must be divisible by 1,000"
    const val INVALID_WINNING_NUMERIC_ERROR_MESSAGE = "[ERROR] Lotto numbers must be numeric"
    const val INVALID_BONUS_NUMERIC_ERROR_MESSAGE = "[ERROR] Bonus number must be numeric"
    const val WINNING_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] Winning numbers must be between 1 and 45"
    const val DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] Winning numbers are duplicated"
    const val DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] Winning numbers and bonus number must not be duplicated"
}
