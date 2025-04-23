package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine(
    private val numberGenerator: () -> List<Int> = { Randoms.pickUniqueNumbersInRange(1, 45, 6) }
) {
    fun purchaseTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / 1000
        return List(ticketCount) { Lotto(numberGenerator().sorted()) }
    }
}
