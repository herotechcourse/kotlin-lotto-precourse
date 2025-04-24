package lotto.model

import lotto.Lotto

class User (private var budget: Int) {
    var lottoTickets: List<Lotto> = emptyList()
        private set // make private set, get only at outer

    fun buyLottoTickets(): List<Lotto> {
        val ticketNum = budget / Lotto.COST
        budget -= ticketNum * Lotto.COST
        lottoTickets = List(ticketNum) { Lotto.getLottoNumbers() }
        return lottoTickets
    }
}