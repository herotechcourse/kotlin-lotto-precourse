package lotto.domain

import lotto.view.InputView
import lotto.view.OutputView

class Game {
    fun run() {
        val ticketsPurchased = InputView.getPurchaseAmount() / lotto.TICKET_PRICE
        val userTicketList = TicketMachine.giveTickets(ticketsPurchased)
        OutputView.printGeneratedTickets(userTicketList, ticketsPurchased)

    }
}
