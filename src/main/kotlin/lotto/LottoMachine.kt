package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.LottoConfig.PRICE_PER_TICKET

object LottoMachine {
    fun generateTickets(amount: Int): List<Lotto> {
        val count = amount / PRICE_PER_TICKET
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}