package lotto

object Messages {
    const val PURCHASE_AMOUNT = "Please enter the purchase amount."
    const val TICKETS_PURCHASED = "You have purchased %d tickets."
    const val ERROR = "[ERROR] %s"
    const val ERROR_INVALID_INPUT = "Invalid input"
    const val ERROR_INVALID_NUMBER = "Enter a valid number"
    const val ERROR_NEGATIVE_NUMBER = "Enter a positive number"
    const val ERROR_NOT_THOUSANDS = "Enter a number divisible by 1000"
    const val ERROR_NOT_SIX_NUMBERS = "It must contain exactly 6 numbers."
    const val ERROR_NOT_UNIQUE = "Numbers must be unique."
    const val ERROR_OUT_OF_RANGE = "Every number must be between 1 and 45"
    const val SEPARATOR = ", "
    const val PREFIX = "["
    const val POSTFIX = "]"
    const val WINNING_NUMBERS= "Please enter last week's winning numbers."
    const val BONUS_NUMBER = "Please enter the bonus number."

    fun display(message: String, vararg args: Any) {
        println(message.format(*args))
    }

}