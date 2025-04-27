package lotto.model

import lotto.exception.LottoException

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { LottoException.INVALID_LOTTO_NUMBERS.getMessage() }
        require(numbers.toSet().size == 6) { LottoException.DUPLICATE_LOTTO_NUMBERS.getMessage() }
    }

    fun getNumbers(): List<Int> = numbers.sorted()
}
