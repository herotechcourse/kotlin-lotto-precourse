package input.config

const val TICKET_AMOUNT_MSG = "Please enter the purchase amount."

const val LAST_WEEK_WINNING_NUMBER_MSG = "Please enter last week's winning numbers."

const val BONUS_NUMBER_MSG = "Please enter the bonus number."

const val TICKET_RESULT_PREFIX = "You have purchased "

const val TICKET_RESULT_POSTFIX = " tickets."

fun getTicketResultMsg(amount: Int): String{
    return TICKET_RESULT_PREFIX + amount + TICKET_RESULT_POSTFIX
}