package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoFactory {
    const val TICKET_PRICE = 1_000

    private fun createOneTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.NUMBER_COUNT)
        return Lotto(numbers)
    }

    fun createMultipleTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / TICKET_PRICE
        val lottoTickets = mutableListOf<Lotto>()
        repeat(ticketCount) {
            lottoTickets.add(createOneTicket())
        }
        return lottoTickets
    }
}