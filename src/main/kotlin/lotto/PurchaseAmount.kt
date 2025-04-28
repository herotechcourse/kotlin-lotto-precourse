package lotto

import lotto.business.LottoErrorMessage

class PurchaseAmount(private val purchaseAmount: Int) {
    val ticketCount
        get() = purchaseAmount / 1000

    init {
        require(purchaseAmount > 0 && purchaseAmount % 1000 == 0) { LottoErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.message }
    }

    fun getPurchaseAmount() = purchaseAmount

    companion object {
        fun from(purchaseAmount: String): PurchaseAmount {
            require(purchaseAmount.toIntOrNull() != null) { LottoErrorMessage.PURCHASE_AMOUNT_NOT_INTEGER.message }
            return PurchaseAmount(purchaseAmount.toInt())
        }
    }
}