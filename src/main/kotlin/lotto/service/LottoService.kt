package lotto.service

import lotto.Lotto
import lotto.domain.LottoTicket
import lotto.util.RandomUtil

class LottoService {

    fun generateTickets(purchaseAmount: Int): List<LottoTicket> {
        val numberOfTickets = purchaseAmount / 1000
        return List(numberOfTickets) { createTicket() }
    }

    private fun createTicket(): LottoTicket {
        val lotto = Lotto(RandomUtil.generateRandomNumbers())
        return LottoTicket(lotto)
    }
}
