package lotto.domain

import lotto.domain.ErrorMessages.INVALID_PURCHASE_UNIT
import lotto.domain.ErrorMessages.INVALID_ZERO_PURCHASE_AMOUNT

data class PurchaseAmount(val amount: Int) {
    val ticketCount: Int
        get() = amount / MONETARY_UNIT

    init {
        require(amount != 0) { INVALID_ZERO_PURCHASE_AMOUNT }
        require(amount % MONETARY_UNIT == 0) { INVALID_PURCHASE_UNIT }
    }

    companion object {
        private const val MONETARY_UNIT = 1_000
    }
}
