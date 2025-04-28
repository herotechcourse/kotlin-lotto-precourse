package lotto

import dialog.getBonusNumberFromDialog
import dialog.getLottosFromTicketAmountThroughDialog
import dialog.getTicketAmountFromDialog
import dialog.getWinningNumberFromDialog

fun main() {
    val ticketAmount: Int = getTicketAmountFromDialog()
    val lottos: Array<Lotto> = getLottosFromTicketAmountThroughDialog(ticketAmount)
    val winningNumbers: Array<Int> = getWinningNumberFromDialog()
    val bonusNumber: Int = getBonusNumberFromDialog()
    MatchManager.init(winningNumbers, bonusNumber)
}
