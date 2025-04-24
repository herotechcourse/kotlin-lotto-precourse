package lotto.domain

import lotto.Lotto

class PurchasedLottos(private val tickets: List<Lotto>) {
    fun count(): Int {
        return tickets.size
    }
    fun getAllTickets():List<Lotto> {
        return tickets
    }
}