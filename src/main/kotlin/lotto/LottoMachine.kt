package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    private const val PRICE_PER_TICKET = 1000

    /**
     * Generates the given number of Lotto tickets.
     * Each ticket contains 6 unique random numbers between 1 and 45, sorted in ascending order.
     */
    fun generateTickets(count: Int): List<Lotto> {
        return List(count) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }

    /**
     * Calculates how many Lotto tickets can be purchased with the given amount.
     * Assumes each ticket costs 1000 units.
     */
    fun getTicketCount(purchaseAmount: Int): Int {
        return purchaseAmount / PRICE_PER_TICKET
    }

}