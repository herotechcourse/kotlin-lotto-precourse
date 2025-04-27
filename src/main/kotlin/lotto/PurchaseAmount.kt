package lotto

import lotto.business.LottoErrorMessage

class PurchaseAmount(private val purchaseAmount: Int) {
    init {
        require(purchaseAmount > 0 && purchaseAmount % 1000 == 0) { LottoErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.message }
    }

    companion object {
        fun from(purchaseAmount: String): PurchaseAmount {
            require(purchaseAmount.toIntOrNull() != null) { LottoErrorMessage.PURCHASE_AMOUNT_NOT_INTEGER.message }
            return PurchaseAmount(purchaseAmount.toInt())
        }
    }
}