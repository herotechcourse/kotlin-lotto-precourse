package lotto
import camp.nextstep.edu.missionutils.Randoms

private const val PRICE: Int = 1000

class TicketMachine (purchaseAmount: Int) {
    private val numberOfTickets: Int
    val tickets: MutableList<List<Int>> = mutableListOf()
    init{
        require(purchaseAmount >= PRICE) { "[ERROR] The purchase amount must be at least 1000." }
        require(purchaseAmount % PRICE == 0) { "[ERROR] The purchase amount must be divisible by 1000." }
        numberOfTickets = purchaseAmount / PRICE
        for (i in 0 until numberOfTickets)
            tickets.add(generateTicket())
    }
    private fun generateTicket():List<Int> =
        Randoms.pickUniqueNumbersInRange(1, 45, 6)
}