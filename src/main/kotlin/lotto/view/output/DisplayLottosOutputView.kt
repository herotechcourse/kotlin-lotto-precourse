package lotto.view.output

import lotto.Lottos

object DisplayLottosOutputView : OutputView<Lottos> {
    override fun display(model: Lottos) {
        val tickets = model.getTickets()
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket.getNumbers())
        }
    }
}