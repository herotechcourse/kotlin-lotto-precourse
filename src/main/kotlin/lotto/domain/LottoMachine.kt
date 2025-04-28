package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoMachine {
    fun issueTickets(ticketCount: Int): List<Lotto> {
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }
}
