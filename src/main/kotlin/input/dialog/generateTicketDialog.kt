package input.dialog

import input.config.printTicketResultMsgWithAmount
import lotto.Lotto

fun getLottosFromTicketAmountThroughDialog(ticketAmount: Int): Array<Lotto>{
    printTicketResultMsgWithAmount(ticketAmount)
    val lottos: Array<Lotto>  = Lotto.generateLottoArray(ticketAmount)
    lottos.forEach { lotto -> println(lotto.toString()) }
    return lottos
}