package lotto.calculation

import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms

class TicketGenerator {

    // Function to generate a single ticket
    private fun generateSingleTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()

        return Lotto(numbers)
    }

    // Function to generate multiple tickets
    fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()

        for (i in 1..numberOfTickets) {
            tickets.add(generateSingleTicket())
        }

        return tickets
    }
}