package lotto.domain

import lotto.view.InputView

class Game {
    fun run() {
        val userTickets = TicketMachine.giveTickets(InputView.getPurchaseAmount())
    }
}
