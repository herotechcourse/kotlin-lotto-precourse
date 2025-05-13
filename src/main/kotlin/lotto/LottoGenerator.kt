package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

object LottoGenerator {
    private const val TICKET_PRICE = 1000

    fun issue(amount: Money): List<Lotto> {
        return List(amount.value / TICKET_PRICE) { randomTicket() }
    }

    private fun randomTicket(): Lotto {
        return Lotto(pickUniqueNumbersInRange(1, 45, 6).sorted())
    }
}