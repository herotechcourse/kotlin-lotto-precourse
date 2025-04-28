package lotto.model

import lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.exception.LottoException

class Lotto(private val numbers: List<Int>) {

    init {
        if (numbers.size != LOTTO_NUMBER_COUNT)
            throw LottoException.InvalidCount()
        if (numbers.toSet().size != LOTTO_NUMBER_COUNT)
            throw LottoException.DuplicateNumbers()
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}
