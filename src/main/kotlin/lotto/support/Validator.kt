package lotto.support

import lotto.support.Message

object Validator {
    private const val TICKET_PRICE= 1000

    fun validatePurchaseAmount(amount: Int){
        require(amount >= TICKET_PRICE) { Message.ERROR_AMOUNT_TOO_SMALL }
        require(amount % TICKET_PRICE == 0) { Message.ERROR_AMOUNT_NOT_DIVISIBLE }
    }
}