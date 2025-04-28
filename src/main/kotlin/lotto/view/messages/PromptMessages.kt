package lotto.view.messages

enum class PromptMessages(val message: String) {
    PURCHASE_AMOUNT("Please enter the purchase amount."),
    WINNING_NUMBERS("Please enter last week's winning numbers."),
    BONUS_NUMBER("Please enter the bonus number."),
    TICKET_COUNT("You have purchased %d tickets."),
    WINNING_STATISTICS("Winning Statistics"),
    TOTAL_RETURN_RATE("Total return rate is %s%%.");

    fun with(vararg args: Any): String {
        return message.format(*args)
    }
}