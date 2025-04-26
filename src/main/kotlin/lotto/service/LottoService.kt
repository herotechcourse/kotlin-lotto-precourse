package lotto.service

import lotto.domain.LottoGenerator
import lotto.domain.PurchaseAmount
import lotto.domain.RandomLottos

class LottoService {
    fun createRandomLotto(amount: Int): RandomLottos {
        val ticketAmount = PurchaseAmount(amount).toTicketAmount()
        val randomLottos = LottoGenerator.generate(ticketAmount)

        return RandomLottos(randomLottos)
    }
}