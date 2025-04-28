package lotto.util

import lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.constants.LottoConstants.MAX
import lotto.constants.LottoConstants.MIN
import lotto.constants.LottoConstants.TICKET_PRICE
import lotto.exception.ApplicationException
import lotto.exception.InputException

object Validator {

    fun validateAmount(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw ApplicationException(InputException.INVALID_INTEGER)
        if (number < TICKET_PRICE)
            throw ApplicationException(InputException.AMOUNT_TOO_SMALL)
        if (number % TICKET_PRICE != 0)
            throw ApplicationException(InputException.AMOUNT_NOT_DIVISIBLE)
        return number
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = StringUtil.convertToList(input)
            .map {
                it.toIntOrNull() ?: throw ApplicationException(InputException.INVALID_INTEGER)
            }
        if (numbers.size != LOTTO_NUMBER_COUNT || numbers.toSet().size != LOTTO_NUMBER_COUNT) {
            throw ApplicationException(InputException.INVALID_WINNING_NUMBERS)
        }
        if (numbers.any { it !in MIN..MAX })
            throw ApplicationException(InputException.NUMBER_OUT_OF_RANGE)
        return numbers
    }

    fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw ApplicationException(InputException.INVALID_INTEGER)
        if (number !in MIN..MAX)
            throw ApplicationException(InputException.NUMBER_OUT_OF_RANGE)
        return number
    }
}
