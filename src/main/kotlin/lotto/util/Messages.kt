package lotto.util

object Messages {
    const val PROMPT_PURCHASE_AMOUNT = "Please enter the purchase amount (must be multiple of 1,000):"
    const val PROMPT_WINNING_NUMBERS = "Enter the 6 winning numbers (comma-separated):"
    const val PROMPT_BONUS_NUMBER = "Enter the bonus number:"

    const val ERROR_NOT_A_NUMBER = "[ERROR] Invalid input: '%s' is not a number."
    const val ERROR_NOT_MULTIPLE_OF_1000 = "[ERROR] Purchase amount must be a multiple of 1,000. Received: %d"
    const val ERROR_INVALID_BONUS_NUMBER = "[ERROR] Bonus number must be between 1 and 45. Received: %d"
    const val ERROR_OUT_OF_RANGE = "[ERROR] Winning numbers must consist of 6 unique numbers from 1 to 45. Received: %s"
    const val ERROR_MALFORMED_LIST = "[ERROR] '%s' is not valid. Please use commas like: 1,2,3,4,5,6"
    const val ERROR_EMPTY_VALUE_AT = "[ERROR] Empty value at position %d. Please check your commas."
    const val ERROR_INVALID_INTEGER = "[ERROR] '%s' is not a valid integer."

    const val ERROR_BONUS_DUPLICATE = "[ERROR] Bonus number must not duplicate any winning number."
}