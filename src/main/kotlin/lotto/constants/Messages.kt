package lotto.constants

enum class ErrorMessage(val message: String) {
    INPUT_IS_BLANK("[ERROR] The purchase amount can't be a null."),
    NOT_A_NUMBER("[ERROR] The purchase amount must be a number."),
    NOT_DIVISIBLE_BY_UNIT("[ERROR] The amount must be a multiple of the ticket price."),
    NUMBER_OUT_OF_RANGE("[ERROR] Numbers must be between 1 and 45."),
    DUPLICATE_NUMBERS("[ERROR] Numbers must not be duplicated"),
    INVALID_NUMBER_COUNT("[ERROR] Lotto must contain exactly 6 numbers.")
}

enum class InputMessage(val message: String) {
    PURCHASE("Please enter the purchase amount."),
    WINNING_NUMBER("Please enter last week's winning numbers."),
    BONUS_NUMBER("Please enter the bonus number.")
}

enum class OutputMessage {
    TICKETS;

    fun message(count: Int): String {
        return "You have purchased $count tickets."
    }
}