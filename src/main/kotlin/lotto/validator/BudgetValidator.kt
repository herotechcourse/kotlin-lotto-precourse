package lotto.validator

import lotto.domain.TicketPrice
import lotto.domain.throwInvalidBudgetException

class BudgetValidator() {
    fun run(value: Int?): Boolean {
        val validatedValue = valid(value)
        return range(validatedValue)
    }

    internal fun range(value: Int): Boolean {
        if (value < TicketPrice.TICKET.value)
            throw throwInvalidBudgetException("")

        return true
    }

    internal fun valid(value: Int?): Int {
        if (value == null)
            throw throwInvalidBudgetException("")

        return value
    }
}