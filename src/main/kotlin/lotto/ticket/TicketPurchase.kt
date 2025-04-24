package lotto.ticket

import lotto.TICKET_COST
import lotto.UserInput

class TicketPurchase {
    var amountOfTicketsBought: Int = 0
    private set
    var tickets: MutableSet<Ticket> = mutableSetOf()
    private set

    fun buyTickets(userInput: UserInput) {
        this.amountOfTicketsBought = userInput.purchaseAmount.floorDiv(TICKET_COST)
    }

    fun generateTickets() {
        for (i in 1..this.amountOfTicketsBought) {
            tickets.add(Ticket())
        }
    }
}