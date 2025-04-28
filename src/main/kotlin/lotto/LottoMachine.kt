package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val purchaseAmount: Int) {

    fun generateTickets(): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        val numTickets = purchaseAmount / 1000
        repeat(numTickets) {
            val ticketNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            tickets.add(Lotto(ticketNumbers))
        }
        return tickets
    }
}
