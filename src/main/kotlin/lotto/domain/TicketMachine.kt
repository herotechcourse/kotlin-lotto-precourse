package lotto.domain


import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.MAX_RANGE
import lotto.MIN_RANGE
import lotto.TICKET_LEN

object TicketMachine {
    fun giveTickets(ticketsPurchased: Int): List<List<Int>> {
        return List(ticketsPurchased) { createTicket().getNumbers() }
    }

    private fun createTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, TICKET_LEN).sorted()
        return (Lotto(numbers))
    }
}