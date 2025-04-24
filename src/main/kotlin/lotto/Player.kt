package lotto

import camp.nextstep.edu.missionutils.Randoms

class Player(private val amount: Int) {

    val numberOfTickets: Int = amount / 1000

    private val tickets: List<Lotto> by lazy {
        generateTickets(numberOfTickets)
    }

    private fun generateTickets(numberOfTickets: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        for (i in 0 until numberOfTickets) {
            tickets.add(Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
        }
        return tickets
    }
}