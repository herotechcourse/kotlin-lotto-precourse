package lotto

class LottoTicketCalculator(val purchasedAmount: Int) {

    init {
        require(purchasedAmount in TICKET_PRICE..MAX_PURCHASE_AMOUNT) { PURCHASE_AMOUNT_ERROR }
    }

    fun calculateQuantity(): Int {
        require(purchasedAmount % TICKET_PRICE == 0) { PURCHASE_AMOUNT_NOT_DIVISIBLE_ERROR }
        return purchasedAmount / TICKET_PRICE
    }

    companion object {
        const val TICKET_PRICE: Int = 1_000
        const val MAX_PURCHASE_AMOUNT: Int = 100_000

        const val PURCHASE_AMOUNT_ERROR: String = "[ERROR] Purchase amount can not exceed $MAX_PURCHASE_AMOUNT KRW."
        const val PURCHASE_AMOUNT_NOT_DIVISIBLE_ERROR: String =
            "[ERROR] Purchase amount should be divisible by $TICKET_PRICE."
    }
}
