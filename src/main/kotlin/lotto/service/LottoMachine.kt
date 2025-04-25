package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine {

    fun generateTickets(amount: Int): List<Lotto>{
        val ticketCount = amount / 1000
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }
}
