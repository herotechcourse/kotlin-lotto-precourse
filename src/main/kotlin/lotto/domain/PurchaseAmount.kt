package lotto.domain

import lotto.exception.DomainException

class PurchaseAmount(private val amount: Int) {
    init {
        validateAmountRange(amount)
        validatePurchasableUnit(amount)
    }

    private fun validateAmountRange(amount: Int) {
        require(amount <= MAXIMUM_AMOUNT) { DomainException.AMOUNT_MUST_NOT_EXCEED.format(MAXIMUM_AMOUNT) }
    }

    private fun validatePurchasableUnit(amount: Int) {
        require(amount % PURCHASE_UNIT == 0) { DomainException.AMOUNT_MUST_ENTERED_AS.format(PURCHASE_UNIT) }
    }

    fun toTicketAmount(): Int = amount / PURCHASE_UNIT

    fun amount(): Int = amount

    companion object {
        private const val MAXIMUM_AMOUNT = 100_000
        private const val PURCHASE_UNIT = 1_000
    }
}