package input.config

internal const val TICKET_AMOUNT_MSG = "Please enter the purchase amount."

internal const val LAST_WEEK_WINNING_NUMBER_MSG = "Please enter last week's winning numbers."

internal const val BONUS_NUMBER_MSG = "Please enter the bonus number."

internal const val TICKET_RESULT_PREFIX = "You have purchased "

internal const val TICKET_RESULT_POSTFIX = " tickets."

internal fun getTicketResultMsg(amount: Int): String{
    return TICKET_RESULT_PREFIX + amount + TICKET_RESULT_POSTFIX
}

fun printTicketAmountMsg(){
    println(TICKET_AMOUNT_MSG)
}
fun printLastWeekWinningNumberMsg(){
    println(LAST_WEEK_WINNING_NUMBER_MSG)
}
fun printBonusNumberMsg(){
    println(BONUS_NUMBER_MSG)
}

fun printTicketResultMsgWithAmount(amount: Int){
    println(getTicketResultMsg(amount))
}