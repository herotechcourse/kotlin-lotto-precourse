package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.util.Config

class TicketMachine(
    private val numberGenerator: () -> List<Int> = { Randoms.pickUniqueNumbersInRange(Config.LOTTO_MIN_NUMBER, Config.LOTTO_MAX_NUMBER, Config.LOTTO_NUMBER_COUNT) }
) {
    fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / Config.TICKET_PRICE
        return List(ticketCount) { Lotto(numberGenerator().sorted()) }
    }
}
