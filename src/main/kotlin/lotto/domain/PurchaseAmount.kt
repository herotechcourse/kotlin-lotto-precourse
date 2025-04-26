package lotto

import lotto.Lotto.Companion.PRICE
import lotto.domain.CurrencyType

class PurchaseAmount(private val amount: Int) {

    init {
        require(amount > 0) { "[ERR] The Purchase amount must be positive. Please Enter again." }
        require(amount >= Lotto.PRICE) { "[ERR] The purchase amount must be greater than or equal to the single lottery ticket price(${CurrencyType.KRW}).  }
    }

    fun toInt(): Int {
        return amount
    }
}
