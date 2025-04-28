package lotto

import input.dialog.getTicketAmountFromDialog
import lotto.Lotto.Companion.generateLottoArray

fun main() {
    val ticketAmount = getTicketAmountFromDialog()

    val lottos: Array<Lotto> = generateLottoArray(ticketAmount)
}
