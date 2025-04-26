package lotto

class LottoPurchaseAmount(val value: Int) {

    init {
        require(value in TICKET_PRICE..MAX_PURCHASE_AMOUNT) { PURCHASE_AMOUNT_ERROR }
        require(value % TICKET_PRICE == 0) { PURCHASE_AMOUNT_NOT_DIVISIBLE_ERROR }
    }

    fun calculateQuantity(): Int {
        return value / TICKET_PRICE
    }

    companion object {
        private const val TICKET_PRICE: Int = 1_000
        private const val MAX_PURCHASE_AMOUNT: Int = 100_000

        private const val PURCHASE_AMOUNT_ERROR: String =
            "[ERROR] Purchase amount can not exceed $MAX_PURCHASE_AMOUNT KRW."
        private const val PURCHASE_AMOUNT_NOT_DIVISIBLE_ERROR: String =
            "[ERROR] Purchase amount should be divisible by $TICKET_PRICE."
    }
}
