package lotto

import camp.nextstep.edu.missionutils.Randoms

class Player(private val amount: Int) {
    companion object {
        const val TICKET_PRICE = 1_000
        const val MAX_AMOUNT = 1_000_000
    }

    init {
        require(amount >= TICKET_PRICE) { "[ERROR] That's enough money to by a ticket :( Each ticket costs 1000 KRW." }
        require(amount <= MAX_AMOUNT) { "[ERROR] Wow, that's too much to spend in Lotto tickets. Enter an amount less than 100000 KRW" }
    }

    val numberOfTickets: Int = amount / TICKET_PRICE

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

    fun getAmount(): Int {
        return amount
    }
}