package model

import lotto.Lotto

class User (private var budget: Int) {
    fun buyLottoTickets(): List<Lotto> {
        val ticketNum = budget / Lotto.COST
        budget -= ticketNum * Lotto.COST
        val ticketList = List(ticketNum) { Lotto.getLottoNumbers() }
        return ticketList
    }
}