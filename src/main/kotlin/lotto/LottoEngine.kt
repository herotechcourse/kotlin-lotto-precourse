package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoEngine {
    private const val TICKET_PRICE = 1000

    fun buyTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / TICKET_PRICE
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }
}