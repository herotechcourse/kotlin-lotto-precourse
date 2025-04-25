package lotto.view

import lotto.Lotto

object OutputView {

    private const val LOTTO_TICKETS_MESSAGE = "You have purchased %d tickets."

    fun showLottoTickets(lottoTickets: List<Lotto>) {
        println(LOTTO_TICKETS_MESSAGE.format(lottoTickets.size))
        lottoTickets.forEach { println(it.numbers()) }
    }
}
