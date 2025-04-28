package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoFactory {
    private fun createOneTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    fun createMultipleTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / 1000
        val lottoTickets = mutableListOf<Lotto>()
        repeat(ticketCount) {
            lottoTickets.add(createOneTicket())
        }
        return lottoTickets
    }
}