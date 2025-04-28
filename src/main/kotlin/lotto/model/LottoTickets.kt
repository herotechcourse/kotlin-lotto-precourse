package lotto.model

import lotto.Lotto

class LottoTickets(private val tickets: List<Lotto>) {

    fun getTickets(): List<Lotto> = tickets
}