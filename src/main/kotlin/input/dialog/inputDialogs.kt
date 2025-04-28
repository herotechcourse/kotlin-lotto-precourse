package input.dialog

import input.config.printTicketAmountMsg
import input.config.printTicketResultMsgWithAmount
import input.getTicketAmountFromInput

fun getTicketAmountFromDialog(): Int{
    printTicketAmountMsg()
    val ticketAmount = getTicketAmountFromInput();
    printTicketResultMsgWithAmount(ticketAmount)
    return ticketAmount
}