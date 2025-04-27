package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoGenerator {
    fun generateTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }

    fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / 1000
        return List(ticketCount) { generateTicket() }
    }
}