package lotto.util

import lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.constants.LottoConstants.MAX
import lotto.constants.LottoConstants.MIN
import lotto.constants.LottoConstants.TICKET_PRICE
import lotto.exception.InputException

object Validator {

    fun validateAmount(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw InputException.InvalidInteger()
        if (number < TICKET_PRICE)
            throw InputException.AmountTooSmall()
        if (number % TICKET_PRICE != 0)
            throw InputException.AmountNotDivisible()
        return number
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = StringUtil.convertToList(input)
            .map {
                it.toIntOrNull() ?: throw InputException.InvalidInteger()
            }
        if (numbers.size != LOTTO_NUMBER_COUNT || numbers.toSet().size != LOTTO_NUMBER_COUNT) {
            throw InputException.InvalidWinningNumbers()
        }
        if (numbers.any { it !in MIN..MAX })
            throw InputException.NumberOutOfRange()
        return numbers
    }

    fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw InputException.InvalidInteger()
        if (number !in MIN..MAX)
            throw InputException.NumberOutOfRange()
        return number
    }
}
