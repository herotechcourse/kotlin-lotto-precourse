package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    fun buyTickets(amount: Int): List<Lotto> {
        val count = amount / 1000
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
        }
    }
}
