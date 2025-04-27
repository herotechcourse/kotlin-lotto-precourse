package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.configuration.LottoConfiguration.PRICE_PER_TICKET

class LottoTicketsGenerator {

    fun generateTickets(amount: Int): List<Lotto> {
        val ticketsAmount = amount / PRICE_PER_TICKET
        return List(ticketsAmount) {
            val ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(ticketNumbers)
        }
    }
}