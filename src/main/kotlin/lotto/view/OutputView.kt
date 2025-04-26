package lotto.view

import lotto.Lotto
import lotto.constants.OutputMessage

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println(OutputMessage.TICKETS.message(tickets.size))
        tickets.forEach { println(it.getNumbers()) }
    }
}