package lotto.model

import lotto.Lotto

class LottoStorage(lottery: List<Lotto>) {
    private val lottery: List<Lotto>

    init {
        this.lottery = lottery.toList()
    }

    fun getAll(): List<Lotto> = lottery
}