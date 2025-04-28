package lotto

object Constants {
    const val INPUT_PURCHASE_AMOUNT = "Please enter the purchase amount."
    const val INPUT_WINNING_NUMBERS = "Please enter last week's winning numbers."
    const val INPUT_BONUS_NUMBER = "Please enter the bonus number."

    const val ERROR_LOTTO_SIZE = "[ERROR] Lotto must contain exactly 6 numbers."
    const val ERROR_LOTTO_RANGE = "[ERROR] Lotto numbers must be between 1 and 45."
    const val ERROR_LOTTO_DUPLICATE = "[ERROR] Lotto numbers must be unique."
    const val ERROR_INVALID_NUMBER = "[ERROR] Please enter a valid number."
    const val ERROR_MULTIPLE_OF_1000 = "[ERROR] Amount must be a multiple of 1000."
    const val ERROR_INVALID_WINNING_COUNT = "[ERROR] You must enter exactly 6 numbers."
    const val ERROR_INVALID_NUMBER_RANGE = "[ERROR] All numbers must be between 1 and 45."
    const val ERROR_DUPLICATED_NUMBER = "[ERROR] Duplicate numbers are not allowed."
    const val ERROR_INVALID_BONUS_NUMBER_RANGE = "[ERROR] Bonus number must be between 1 and 45."
    const val ERROR_DUPLICATED_BONUS = "[ERROR] Bonus number must not be one of the winning numbers."

    const val PURCHASED_TICKETS = "You have purchased %d tickets."
    const val RESULT_WINNING_STATISTICS = "Winning Statistics"
    const val RESULT_SEPARATOR = "---"
    const val WINNING_RESULT = "%s (%,d KRW) – %d tickets"
    const val RETURN_RATE = "Total return rate is %.1f%%."

    const val LINE_SEPARATOR = "\n"
    const val LOTTO_DELIMITER = ", "
    const val LOTTO_PREFIX = "["
    const val LOTTO_POSTFIX = "]"
}
