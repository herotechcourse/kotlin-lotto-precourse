package lotto.model

import lotto.Lotto

class SequentialLottoTicketMachine : LottoTicketMachine {
    companion object {
        private val FIXED_TICKETS = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(11, 12, 13, 14, 15, 16)),
            Lotto(listOf(21, 22, 23, 24, 25, 26)),
            Lotto(listOf(31, 32, 33, 34, 35, 36)),
            Lotto(listOf(41, 42, 43, 44, 45, 1))
        )
    }

    override fun buyLotto(quantity: Int): List<Lotto> {
        return List(quantity) { index ->
            FIXED_TICKETS[index % FIXED_TICKETS.size]
        }
    }
}
