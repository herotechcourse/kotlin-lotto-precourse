package lotto

import camp.nextstep.edu.missionutils.Randoms

class TicketGenerator {
    fun generateTicket(): List<Int> {
        val ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return ticket
    }

    fun generateMultiples(numberOfTickets: Int): List<List<Int>> {
        val ticketsList = mutableListOf<List<Int>>()
        repeat(numberOfTickets) {
            ticketsList.add(generateTicket())
        }
        return ticketsList
    }
}