package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine(private val purchaseAmount: Int) {

    fun calculateTicketCount() = purchaseAmount / 1000

    fun generateTickets(ticketCount: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        repeat(ticketCount) {
            tickets.add(Lotto(generateRandomNumbers()))
        }
        return tickets
    }

    private fun generateRandomNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1,45,6).sorted()
    }

}