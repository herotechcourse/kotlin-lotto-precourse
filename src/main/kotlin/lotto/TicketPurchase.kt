package lotto

import camp.nextstep.edu.missionutils.Randoms

class TicketPurchase {
    var amountOfTicketsBought: Int = 0
    private set
    var tickets: MutableSet<Lotto> = mutableSetOf()
        private set

    fun buyTickets(userInput: UserInput) {
        this.amountOfTicketsBought = userInput.purchaseAmount.floorDiv(TICKET_COST)
    }

    fun generateTickets() {
        for (i in 1..this.amountOfTicketsBought) {
            this.tickets.add(Lotto(Randoms.pickUniqueNumbersInRange(LOWEST_NUMBER, HIGHEST_NUMBER, 6)))
        }
    }
}