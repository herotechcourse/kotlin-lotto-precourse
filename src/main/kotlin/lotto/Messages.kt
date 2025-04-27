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
    const val ERROR_BONUS_IN_WINNER = "Bonus number should be different than winner numbers"
    const val SEPARATOR = ", "
    const val PREFIX = "["
    const val POSTFIX = "]"
    const val WINNING_NUMBERS = "Please enter last week's winning numbers."
    const val BONUS_NUMBER = "Please enter the bonus number."
    const val WINNING_STATISTICS = "Winning Statistics\n---"
    const val MATCH_THREE = "3 Matches (5,000 KRW) - %d tickets"
    const val MATCH_FOUR = "4 Matches (50,000 KRW) - %d tickets"
    const val MATCH_FIVE = "5 Matches (1,500,000 KRW) - %d tickets"
    const val MATCH_FIVE_BONUS = "5 Matches + Bonus Ball (30,000,000 KRW) - %d tickets"
    const val MATCH_SIX = "6 Matches (2,000,000,000 KRW) - %d tickets"
    const val RETURN_RATE = "Total return rate is %.1f%%."

    fun display(message: String, vararg args: Any) {
        println(message.format(*args))
    }
}