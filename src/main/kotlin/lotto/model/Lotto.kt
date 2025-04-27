package lotto.model

import lotto.exception.LottoException

class Lotto(private val numbers: List<Int>) {

    init {
        if (numbers.size != 6) throw LottoException.InvalidCount()
        if (numbers.toSet().size != 6) throw LottoException.DuplicateNumbers()
    }


    fun getNumbers(): List<Int> = numbers.sorted()
}
