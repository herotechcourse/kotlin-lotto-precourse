package lotto.domain.model

import lotto.config.Messages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Messages.LOTTO_NUMBERS_NOT_SIX }
        require(checkDuplicates(numbers)) { Messages.LOTTO_NUMBERS_DUPLICATE }
    }

    private fun checkDuplicates(numbers: List<Int>) = numbers.toSet().size == numbers.size

    fun matchCount(other: List<Int>): Int {
        return numbers.toSet().intersect(other.toSet()).size
    }

    fun containsSingleNumber(number: Int): Boolean {
        return numbers.contains(number)
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }
}
