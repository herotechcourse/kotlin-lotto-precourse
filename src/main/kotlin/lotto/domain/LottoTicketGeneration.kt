package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoTicketGeneration  {

    // Randomly generate list of tickets
    fun generateTickets(numberTickets: Long): List<Lotto> {

        val lottoTickets = mutableListOf<Lotto>()
        for (i in 1 .. numberTickets) {
            val ticket = Randoms.pickUniqueNumbersInRange(
                Lotto.MIN_VALUE_LOTTO,
                Lotto.MAX_VALUE_LOTTO,
                Lotto.SIZE_LOTTO
            ).sorted()
            lottoTickets.add(Lotto(ticket))
        }

        return lottoTickets
    }

    // Print list of tickets
    fun printLottoTickets(lottoTickets: List<Lotto>) {

        println("You have purchased ${lottoTickets.size} tickets.")
        for (ticket in lottoTickets) {
            println(ticket.getTicket())
        }
    }
}