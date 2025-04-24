package lotto.ticket

import lotto.TICKET_COST

class TicketPurchase {
    var purchasedTickets: Int = 0
    private set
    var tickets: MutableSet<Ticket> = mutableSetOf()
    private set

    fun setPurchasedTickets(purchaseAmount: Int) {
        this.purchasedTickets = purchaseAmount.floorDiv(TICKET_COST)
    }
}