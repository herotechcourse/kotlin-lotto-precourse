package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoMachine {
    fun generateTickets(count: Int): List<LottoTicket> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            LottoTicket(Lotto(numbers))
        }
    }
}
