package input.validation

import error.config.INVALID_LOTTO_NUMBER_MSG
import error.config.TICKET_AMOUNT_MUST_BE_MULTIPLE_MSG
import error.config.TICKET_AMOUNT_MUST_BE_POSITIVE_MSG
import input.config.TICKET_AMOUNT_MSG
import lotto.config.*

fun validateAndReturnLottoNumber(num: Int): Int{
    validateLottoNumber(num)
    return num
}
internal fun validateLottoNumber(num: Int) {
    if(num !in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
        throw IllegalArgumentException(INVALID_LOTTO_NUMBER_MSG)
}

fun validateAndReturnTicketAmount(amount: Int): Int {
    validateTicketAmount(amount)
    return amount
}

internal fun validateTicketAmount(amount: Int) {
    if(amount > 0)
        throw IllegalArgumentException(TICKET_AMOUNT_MUST_BE_POSITIVE_MSG)
    if(amount % TICKET_PRICE > 0)
        throw IllegalArgumentException(TICKET_AMOUNT_MUST_BE_MULTIPLE_MSG)
}