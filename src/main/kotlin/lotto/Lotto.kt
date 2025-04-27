package lotto

import lotto.Constants.LOTTO_MAX_NUMBER
import lotto.Constants.LOTTO_MIN_NUMBER
import lotto.Constants.LOTTO_NUMBER_COUNT


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto must contain exactly $LOTTO_NUMBER_COUNT numbers." }
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            "[ERROR] Lotto numbers must be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER."
        }
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    fun matchCount(winning: List<Int>): Int = numbers.count { it in winning }

    fun contains(number: Int): Boolean = number in numbers
}
