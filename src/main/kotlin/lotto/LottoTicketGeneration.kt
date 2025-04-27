package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoTicketGeneration (private val numberTickets: Int) {

    val tickets = mutableListOf<Lotto>()


    fun generateTicket(){
        // val tickets = listOf<Lotto>()
        repeat(numberTickets) {
            val ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            tickets.add(Lotto(ticket))
        }
        //return tickets
    }

    fun showTickets() {
        println("You have purchased $numberTickets tickets.")
        for (ticket in tickets) {
            println(ticket.getTicket())
        }
    }
}