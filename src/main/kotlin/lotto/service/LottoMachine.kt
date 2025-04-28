package lotto.service

import lotto.Lotto
import lotto.domain.LottoNumberGenerator
import lotto.domain.PurchasedLottos
import lotto.domain.RandomLottoGenerator
import lotto.util.Constants

class LottoMachine(private val numberGenerator: LottoNumberGenerator=RandomLottoGenerator()) {

    fun issueTickets(purchaseAmount: Int) :PurchasedLottos{
        val ticketAmount = purchaseAmount / Constants.PURCHASE_AMOUNT_UNIT
        val tickets = List(ticketAmount){
            val randomNumbers = numberGenerator.generate()
            Lotto(randomNumbers)
        }
        return PurchasedLottos(tickets)
    }
}