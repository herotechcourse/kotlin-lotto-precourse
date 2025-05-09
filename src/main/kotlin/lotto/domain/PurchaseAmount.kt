package lotto.domain

import lotto.Lotto
import lotto.controller.ValidatedResult
import lotto.util.CommonMessages
import lotto.util.ErrorReasonBuilder

@JvmInline
value class PurchaseAmount(val amount: Int) {

    init {
        require(amount >= Lotto.PRICE) { AMOUNT_BELOW_TICKET_PRICE }
    }

    fun countPurchasableTickets(ticketPrice: Int): Int {
        return amount / ticketPrice
    }

    companion object {
        val AMOUNT_BELOW_TICKET_PRICE = "The purchase amount must be greater than or equal to the single lottery ticket price(${"%,d".format(Lotto.PRICE)}${Lotto.CURRENCY})"

        fun validate(raw: String): ValidatedResult<PurchaseAmount> {
            val builder = ErrorReasonBuilder()
            val number = raw.toIntOrNull()
            builder.require(number != null, CommonMessages.INVALID_NUMBER_FORMAT)
            builder.require(number != null && number >= Lotto.PRICE, AMOUNT_BELOW_TICKET_PRICE)

            if (builder.inEmpty()) return ValidatedResult.Success(PurchaseAmount(number!!))
            return ValidatedResult.Failure(builder.getReasons())
        }
    }
}
