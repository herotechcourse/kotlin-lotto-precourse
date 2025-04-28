package lotto.domain

import lotto.constant.Constants

class Money(private val amount: Int) {

    init {
        require(amount >= TICKET_PRICE) {
            Constants.ERROR_INVALID_PURCHASE_AMOUNT
        }
        require(amount % TICKET_PRICE == 0) {
            Constants.ERROR_INVALID_PURCHASE_AMOUNT
        }
    }

    fun countTickets(): Int = amount / TICKET_PRICE

    fun value(): Int = amount

    companion object {
        const val TICKET_PRICE = 1000
    }
}