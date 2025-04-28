package lotto.model

import lotto.Lotto

class LottoMaker {

    fun generateLotteries(money: Int): List<Lotto> {
        val ticketQuantity = calculateLottoTicket(money)
        val lotteries = List(ticketQuantity) { Lotto.generate() }
        return lotteries
    }

    private fun calculateLottoTicket(money: Int): Int {
        return money / 1000
    }


}