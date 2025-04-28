package input.dialog

import input.config.printTicketAmountMsg
import input.config.printTicketResultMsgWithAmount
import input.getTicketAmountFromInput

fun getTicketAmountFromDialog(): Int{
    printTicketAmountMsg()
    return getTicketAmountFromInput()
}