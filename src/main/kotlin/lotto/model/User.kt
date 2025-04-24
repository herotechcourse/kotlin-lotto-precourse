package lotto.model

import lotto.Lotto

class User(private val budget: Long) {
    var usedAmount: Long = 0L
    var earnedAmount: Long = 0L
    var lottoTickets: List<Lotto> = emptyList()
        private set // make private set, get only at outer

    init {
        buyLottoTickets()
    }

    private fun buyLottoTickets() {
        val ticketNum = budget / Lotto.COST
        usedAmount += ticketNum * Lotto.COST
        lottoTickets = List(ticketNum.toInt()) { Lotto.getLottoNumbers() }
    }


}