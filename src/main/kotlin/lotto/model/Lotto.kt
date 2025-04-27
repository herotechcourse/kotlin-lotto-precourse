package lotto.model

import lotto.exception.LottoException

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { throw LottoException.InvalidCount() }
        require(numbers.toSet().size == 6) { throw LottoException.DuplicateNumbers() }
    }


    fun getNumbers(): List<Int> = numbers.sorted()
}
