package lotto

import lotto.Consts.TICKET_COST

class IssuedTicket(
    private val purchaseAmount: Int,
    private val randomGenerator: RandomGenerator,
) : IssuedTicketValidator {

    init {
        validatePurchaseAmount(purchaseAmount)
    }

    fun getCount() = purchaseAmount / TICKET_COST

    fun getRandomUniqueNumbers() = randomGenerator.nextSortedUniqueNumbers()
}
