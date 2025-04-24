package lotto

import camp.nextstep.edu.missionutils.Randoms

class Player(private val amount: Int) {

    init {
        require(amount >= 1000) { "[ERROR] That's enough money to by a ticket :( \n Each ticket costs 1000 KRW." }
        require(amount <= 100000) {"[ERROR] Wow, that's too much to spend in Lotto tickets. \n Enter an amount less than 100000 KRW"}
    }
    val numberOfTickets: Int = amount / 1000

    val tickets: List<Lotto> by lazy {
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