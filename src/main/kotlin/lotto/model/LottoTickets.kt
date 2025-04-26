package lotto.model

import lotto.Lotto
import lotto.util.RandomGenerator

class LottoTickets(
    ticketCount: Int
) {
    private val tickets: List<Lotto> = List(ticketCount) {
        Lotto(RandomGenerator.generateLottoNumbers())
    }

    fun getTickets(): List<Lotto> {
        return tickets
    }
}
