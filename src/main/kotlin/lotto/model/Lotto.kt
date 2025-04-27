package lotto.model

import lotto.exception.ApplicationException
import lotto.exception.LottoException

class Lotto(private val numbers: List<Int>) {

    init {
        if (numbers.size != 6) {
            throw ApplicationException(LottoException.INVALID_LOTTO_NUMBERS)
        }
        if (numbers.toSet().size != 6) {
            throw ApplicationException(LottoException.DUPLICATE_LOTTO_NUMBERS)
        }
    }


    fun getNumbers(): List<Int> = numbers.sorted()
}
