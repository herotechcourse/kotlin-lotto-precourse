package lotto.domain

import lotto.Lotto
import lotto.support.*
import camp.nextstep.edu.missionutils.Randoms

object LottoMachine{
    fun generateTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / TICKET_PRICE
        return List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER, TICKET_NUMBERS_COUNT))
        }
    }
}