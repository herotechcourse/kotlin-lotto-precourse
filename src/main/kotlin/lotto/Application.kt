package lotto

import input.dialog.getLottosFromTicketAmountThroughDialog
import input.dialog.getTicketAmountFromDialog
import input.dialog.getWinningNumberFromDialog

fun main() {
    val ticketAmount: Int = getTicketAmountFromDialog()
    val lottos: Array<Lotto> = getLottosFromTicketAmountThroughDialog(ticketAmount)
    val winningNumber: Array<Int> = getWinningNumberFromDialog()

}
