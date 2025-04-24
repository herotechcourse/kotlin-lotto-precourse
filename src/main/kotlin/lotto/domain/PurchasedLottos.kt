package lotto.domain

import lotto.Lotto

class PurchasedLottos(private val tickets: List<Lotto>) {
    fun count(): Int {
        return tickets.size
    }
}