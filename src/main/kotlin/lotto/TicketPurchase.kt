package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.HIGHEST_NUMBER
import lotto.constants.LOWEST_NUMBER
import lotto.constants.TICKET_COST

class TicketPurchase {
    var amountOfTicketsBought: Int = 0
    private set
    var tickets: MutableList<Lotto> = mutableListOf()
        private set

    fun buyTickets(userInput: UserInput) {
        this.amountOfTicketsBought = userInput.purchaseAmount / TICKET_COST
    }

    fun generateTickets() {
        for (i in 1..this.amountOfTicketsBought) {
            val ticketNumbers = Randoms.pickUniqueNumbersInRange(LOWEST_NUMBER, HIGHEST_NUMBER, 6)
            this.tickets.add(Lotto(ticketNumbers))
        }
    }
}