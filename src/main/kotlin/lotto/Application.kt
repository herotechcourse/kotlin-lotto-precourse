package lotto

import input.dialog.getLottosFromTicketAmountThroughDialog
import input.dialog.getTicketAmountFromDialog
import lotto.Lotto.Companion.generateLottoArray

fun main() {
    val ticketAmount: Int = getTicketAmountFromDialog()
    val lottos: Array<Lotto> = getLottosFromTicketAmountThroughDialog(ticketAmount)
}
