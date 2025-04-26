package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine {
    fun generateTickets(amount: Int): List<Lotto> {
        require(amount >= 0) { "[ERROR] Purchase amount cannot be negative." }
        require(amount % TICKET_PRICE == 0) { "[ERROR] Purchase amount must be a multiple of 1,000." }
        
        val ticketCount = amount / TICKET_PRICE
        return List(ticketCount) { generateTicket() }
    }

    private fun generateTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_PER_TICKET)
        return Lotto(numbers)
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBERS_PER_TICKET = 6
    }
}
