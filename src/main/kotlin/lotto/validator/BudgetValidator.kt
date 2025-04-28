package lotto.validator

import lotto.domain.TicketPrice
import lotto.domain.throwInvalidBudgetException

class BudgetValidator() {
    fun run(value: Int): Int {
        return range(value)
    }

    internal fun range(value: Int): Int {
        if (value < TicketPrice.TICKET.value)
            throwInvalidBudgetException("[ERROR] Budget value must be greater than ${TicketPrice.TICKET.value}")
        return value
    }
}