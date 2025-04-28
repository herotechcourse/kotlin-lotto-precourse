package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun createTickets(count : Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()

        for (i in 1..count) {
            val num = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            tickets.add(Lotto(num))
        }

        return tickets
    }
}