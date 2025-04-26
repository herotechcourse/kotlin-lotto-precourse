package lotto.support

import lotto.support.Message

object Validator {
    private const val TICKET_PRICE= 1000

    fun validatePurchaseAmount(amount: Int){
        if (amount < TICKET_PRICE)
            throw(IllegalArgumentException(Message.ERROR_AMOUNT_TOO_SMALL))
        if (amount % TICKET_PRICE != 0)
            throw(IllegalArgumentException(Message.ERROR_AMOUNT_NOT_DIVISIBLE))
    }
}