package lotto.validator

import lotto.domain.TicketPrice
import lotto.domain.throwInvalidBudgetException

class BudgetValidator() {
    fun run(value: Int?): Int {
        val validatedValue = valid(value)
        return range(validatedValue)
    }

    internal fun range(value: Int): Int {
        if (value < TicketPrice.TICKET.value)
            throw throwInvalidBudgetException("")

        return value
    }

    internal fun valid(value: Int?): Int {
        if (value == null)
            throw throwInvalidBudgetException("")

        return value
    }
}