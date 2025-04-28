package lotto

object Messages {
    const val ERROR = "[ERROR] "

    const val INPUT_PURCHASE = "Please enter the purchase amount."
    const val INPUT_WINNING_NUMBERS = "Please enter last week's winning numbers."
    const val INPUT_BONUS_NUMBER = "Please enter the bonus number."

    const val INPUT_NOT_DIVIDABLE = ERROR + "Input must be divided by lotto amount 1000."
    const val NOT_A_VALID_NUMBER = ERROR + "Please enter a valid number."
    const val WINNING_NUMBER_DUPLICATE = ERROR + "Please enter non duplicate numbers."
    const val BONUS_NUMBER_DUPLICATE = ERROR + "Please enter non duplicate number with winning numbers."
    const val WINNING_NUMBER_OVER_RANGE = ERROR + "Please enter number range in 1 to 45."
    const val WINNING_NUMBER_SIZE_NOT_SIX = ERROR + "Please enter 6 numbers."
    const val NUMBER_NOT_POSITIVE = ERROR + "Please enter a positive number."
    const val INVALID_INPUT = ERROR + "Invalid input."
    const val UNEXPECTED_MESSAGE = ERROR + "Unexpected error."
}
