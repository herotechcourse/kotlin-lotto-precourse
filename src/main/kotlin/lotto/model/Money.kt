package lotto.model

import lotto.common.ErrorMessages

class Money(private val amount: Int?) {
    init {
        require(amount != null) { ErrorMessages.INVALID_PURCHASE_AMOUNT_TYPE }
        require(amount in MIN..MAX) { ErrorMessages.INVALID_PURCHASE_AMOUNT_UNIT }
    }

    fun getAmount(): Int = amount!!

    companion object {
        private const val MIN = 1000
        private const val MAX = Int.MAX_VALUE
    }
}