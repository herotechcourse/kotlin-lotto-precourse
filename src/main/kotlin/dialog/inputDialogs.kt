package dialog

import input.config.printBonusNumberMsg
import input.config.printLastWeekWinningNumberMsg
import input.config.printTicketAmountMsg
import input.getBonusNumberFromInput
import input.getLottoNumberArrayFromInput
import input.getTicketAmountFromInput

fun getTicketAmountFromDialog(): Int{
    printTicketAmountMsg()
    val ticketAmount: Int = getTicketAmountFromInput()
    println()
    return ticketAmount
}

fun getWinningNumberFromDialog(): Array<Int>{
    printLastWeekWinningNumberMsg()
    val winningNumbers: Array<Int> = getLottoNumberArrayFromInput()
    println()
    return winningNumbers
}

fun getBonusNumberFromDialog(): Int{
    printBonusNumberMsg()
    val bonusNumber: Int = getBonusNumberFromInput()
    println()
    return bonusNumber
}