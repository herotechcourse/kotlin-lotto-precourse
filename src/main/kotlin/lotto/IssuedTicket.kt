package lotto

class IssuedTicket(
    private val purchaseAmount: Int,
    private val randomGenerator: RandomGenerator,
) : IssuedTicketValidator {

    init {
        validatePurchaseAmount(purchaseAmount)
    }

    fun getCount() = purchaseAmount / TICKET_COST

    fun getRandomUniqueNumbers() = randomGenerator.nextSortedUniqueNumbers()

    companion object {
        private const val TICKET_COST = 1000
    }
}
