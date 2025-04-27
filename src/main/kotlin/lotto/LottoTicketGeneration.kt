package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoTicketGeneration  {

    fun generateTicket(numberTickets: Int): List<Lotto> {

        val lottoTickets = mutableListOf<Lotto>()
        repeat(numberTickets) {
            val ticket = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            lottoTickets.add(Lotto(ticket))
        }
        return lottoTickets

    }

//    fun showTickets() {
//
//        println("You have purchased $numberTickets tickets.")
//        for (ticket in tickets) {
//            println(ticket.getTicket())
//        }
//    }
}