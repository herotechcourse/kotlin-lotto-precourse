package lotto

class IssuedTicket(
    private val purchaseAmount: Int,
    private val randomGenerator: DefaultRandomGenerator,
) : IssuedTicketValidator {

    init {
        validatePurchaseAmount(purchaseAmount)
    }
}
