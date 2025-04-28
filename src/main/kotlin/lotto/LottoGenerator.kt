package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.Config.TICKET_PRICE

object LottoGenerator {
    fun generateTicket(amount: Int): List<Lotto> {
        val count = amount / TICKET_PRICE
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}