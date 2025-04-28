package lotto.dto

import lotto.view.validator.NumericValidator

data class PurchaseAmount(val amount: String) {
    val amountValue: Int

    init {
        amountValue = NumericValidator.validate(amount)
    }

    fun getTicketCount(): Int {
        return amountValue / 1000
    }

}