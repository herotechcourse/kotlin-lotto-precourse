package lotto.domain

import lotto.Lotto

class LottoTicket(private val lotto: Lotto) {
    fun getNumbers(): List<Int> {
        return lotto.getNumbers()
    }

    fun getLotto(): Lotto {
        return lotto
    }
}