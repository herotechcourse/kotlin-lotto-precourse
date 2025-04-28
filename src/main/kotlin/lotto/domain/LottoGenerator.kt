package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto


object LottoGenerator {

    fun generateFrom(money: Money): LottoTickets {
        val count = money.countTickets()
        val tickets = List(count) {
            Lotto.of(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
        return LottoTickets(tickets)
    }
}