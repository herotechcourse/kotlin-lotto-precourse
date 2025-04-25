package lotto.messages

enum class PromptMessages(val message: String) {
    PURCHASE_AMOUNT("Please enter the purchase amount."),
    WINNING_NUMBERS("Please enter last week's winning numbers."),
    BONUS_NUMBER("Please enter the bonus number."),
    TICKET_COUNT("You have purchased %d tickets.");

    fun with(vararg args: Any): String {
        return message.format(*args)
    }

}