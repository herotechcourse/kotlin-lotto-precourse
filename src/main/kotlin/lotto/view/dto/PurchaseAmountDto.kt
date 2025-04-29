package lotto.view.dto

import lotto.error.ExceptionMessage

data class PurchaseAmountDto(val amount: Int) {
    init {
        require(this.amount > 0 && this.amount % 1_000 == 0) { ExceptionMessage.INVALID_PURCHASE_AMOUNT.errorMessage }
    }
}
