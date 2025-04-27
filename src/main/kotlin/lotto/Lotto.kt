package lotto

import lotto.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.LottoConstants.MAX_LOTTO_NUMBER
import lotto.LottoConstants.MIN_LOTTO_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { "Lotto numbers must be unique." }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { "Lotto numbers must be in the range 1 to 45" }
    }

    fun contains(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    fun match(other: Lotto): Int {
        return numbers.toSet().intersect(other.numbers.toSet()).size
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
