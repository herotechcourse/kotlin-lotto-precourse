package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.config.Config.TICKET_PRICE

object LottoGenerator {
    fun generateTicket(amount: Int): Int {
        val count = amount / TICKET_PRICE
        return count
    }
}