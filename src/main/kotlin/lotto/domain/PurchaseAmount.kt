package lotto.domain

class PurchaseAmount(private val amount: Int) {
    init {
        validateAmountRange(amount)
        validatePurchasableUnit(amount)
    }

    private fun validateAmountRange(amount: Int) {
        require(amount <= MAXIMUM_AMOUNT) { "[ERROR] Amount must not exceed $MAXIMUM_AMOUNT" }
    }

    private fun validatePurchasableUnit(amount: Int) {
        require(amount % PURCHASE_UNIT == 0) { "[ERROR] Purchase amount must entered as $PURCHASE_UNIT" }
    }

    fun toTicketNumber(): Int = amount / PURCHASE_UNIT

    companion object {
        private const val MAXIMUM_AMOUNT = 100_000
        private const val PURCHASE_UNIT = 1_000
    }
}