package lotto.domain

import lotto.domain.ErrorMessages.INVALID_PURCHASE_UNIT

data class PurchaseAmount(val amount: Int) {
    init {
        require(amount % MONETARY_UNIT == 0) { INVALID_PURCHASE_UNIT }
    }

    companion object {
        private const val MONETARY_UNIT = 1_000
    }
}
