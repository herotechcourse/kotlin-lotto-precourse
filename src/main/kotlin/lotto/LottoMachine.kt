package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    private const val PRICE_PER_TICKET = 1000

    fun generateTickets(amount: Int): List<Lotto> {
        val count = amount / PRICE_PER_TICKET
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}