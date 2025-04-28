package input.dialog

import input.config.printTicketAmountMsg
import input.config.printTicketResultMsgWithAmount

fun getTicketAmountFromDialog(): Int{
    printTicketAmountMsg()

    printTicketResultMsgWithAmount(0)
    return 0
}