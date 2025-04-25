package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame {

    fun createLottoTickets(amount: Int): List<Lotto> {
        if(amount <= 0) throw IllegalArgumentException("[Error] Amount must be greater than 0")

        val tickets = mutableListOf<Lotto>()
        repeat(amount) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
            tickets.add(lotto)
        }
        return tickets
    }
}
