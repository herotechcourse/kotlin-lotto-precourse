package lotto.domain

import lotto.Lotto

class PurchaseAmount(private val amount: Int) {

    init {
        require(amount > 0) { "The Purchase amount must be positive." }
        require(amount >= Lotto.PRICE) { "The purchase amount must be greater than or equal to the single lottery ticket price(${String.format("%,d", Lotto.PRICE)}${Lotto.CURRENCY})."}
    }

    fun countPurchasableTickets(ticketPrice: Int): Int {
        return amount / ticketPrice
    }

    fun toInt(): Int {
        return amount
    }
}
