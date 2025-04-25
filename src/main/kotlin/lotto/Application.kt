package lotto

import lotto.service.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // TODO: Implement the program
    try {
        val amount = InputView.readPurchaeAmount()
        val ticketCount = amount / 1000

        val machine = LottoMachine()
        val tickets = machine.generateTickets(ticketCount)

        OutputView.printTickets(tickets)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
