package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    fun issueTickets(ticketCount: Int): List<Lotto> {
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }
}
