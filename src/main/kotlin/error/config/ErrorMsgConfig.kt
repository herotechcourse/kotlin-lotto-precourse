package error.config

import lotto.config.MAX_LOTTO_NUMBER
import lotto.config.MIN_LOTTO_NUMBER
import lotto.config.TICKET_PRICE

const val ERROR_MSG_PREFIX = "[ERROR] "

const val INVALID_LOTTO_NUMBER_MSG = "Lotto numbers must be between $MIN_LOTTO_NUMBER and $MAX_LOTTO_NUMBER."
const val TICKET_AMOUNT_MUST_BE_POSITIVE_MSG = "Ticket amount must be a number larger than 0."
const val TICKET_AMOUNT_MUST_BE_MULTIPLE_MSG = "Ticket amount must be a multiple of the ticket price($TICKET_PRICE)."