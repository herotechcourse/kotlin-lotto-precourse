package lotto

import lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.exception.ApplicationException
import lotto.exception.LottoException

class Lotto(private val numbers: List<Int>) {

    init {
        if (numbers.size != LOTTO_NUMBER_COUNT)
            throw ApplicationException(LottoException.INVALID_LOTTO_NUMBERS)
        if (numbers.toSet().size != LOTTO_NUMBER_COUNT)
            throw ApplicationException(LottoException.DUPLICATE_LOTTO_NUMBERS)
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}
