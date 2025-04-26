package lotto

import camp.nextstep.edu.missionutils.Randoms

class TicketGenerator {
    fun generateTicket(): Lotto {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        val ticket = Lotto(randomNumbers)
        return ticket
    }

    fun generateMultiples(numberOfTickets: Int): List<Lotto> {
        val ticketsList = mutableListOf<Lotto>()
        repeat(numberOfTickets) {
            ticketsList.add(generateTicket())
        }
        return ticketsList
    }
}