package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    fun generateTickets(amount: Int): List<Lotto> {
        val count = amount / 1000
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}
