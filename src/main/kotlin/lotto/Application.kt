package lotto

import input.dialog.getBonusNumberFromDialog
import input.dialog.getLottosFromTicketAmountThroughDialog
import input.dialog.getTicketAmountFromDialog
import input.dialog.getWinningNumberFromDialog

fun main() {
    val ticketAmount: Int = getTicketAmountFromDialog()
    val lottos: Array<Lotto> = getLottosFromTicketAmountThroughDialog(ticketAmount)
    val winningNumbers: Array<Int> = getWinningNumberFromDialog()
    val bonusNumber: Int = getBonusNumberFromDialog()
    MatchManager.init(winningNumbers, bonusNumber)
}
