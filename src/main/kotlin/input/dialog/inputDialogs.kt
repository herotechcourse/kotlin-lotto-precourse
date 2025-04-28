package input.dialog

import input.config.printLastWeekWinningNumberMsg
import input.config.printTicketAmountMsg
import input.getLottoNumberArrayFromInput
import input.getTicketAmountFromInput

fun getTicketAmountFromDialog(): Int{
    printTicketAmountMsg()
    val ticketAmount: Int = getTicketAmountFromInput()
    println()
    return ticketAmount
}

fun getWinningNumberFrpmDialog(): Array<Int>{
    printLastWeekWinningNumberMsg()
    val winningNumbers: Array<Int> = getLottoNumberArrayFromInput()
    println()
    return winningNumbers
}