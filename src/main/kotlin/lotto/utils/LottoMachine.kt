package lotto.utils

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoMachine {
    fun calculateTicketCount(purchaseAmount: Int): Int {
        return purchaseAmount / 1000
    }

    fun generateTickets(ticketCount: Int): List<Lotto> {
        return List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)).sort()
        }
    }
}