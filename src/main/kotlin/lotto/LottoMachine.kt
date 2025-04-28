package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateTickets(purchaseAmount: Int): List<LottoTicket> {
        val ticketCount = purchaseAmount / 1000
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            LottoTicket(numbers)
        }
    }
}
