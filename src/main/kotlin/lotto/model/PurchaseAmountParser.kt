package lotto.model

object PurchaseAmountParser {
    private const val ONE_TICKET_UNIT = 1000

    fun parse(purchaseAmount: Int): Int {
        val ticketCount = purchaseAmount / ONE_TICKET_UNIT

        return ticketCount
    }
}
