package lotto

import lotto.model.LOTTO_NUMBER_END
import lotto.model.LOTTO_NUMBER_START

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { NOT_SIX_NUMBERS }
        require(numbers.all { it in LOTTO_NUMBER_START..LOTTO_NUMBER_END }) { INVALID_RANGE }
        require(numbers == numbers.sorted()) { NOT_ASCENDING_ORDER }
        require(numbers.distinct() == numbers) { NOT_UNIQUE_NUMBER }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    companion object {
        private const val LOTTO_SIZE = 6

        private const val NOT_SIX_NUMBERS = "[ERROR] Lotto must contain exactly 6 numbers. "
        private const val INVALID_RANGE = "[ERROR] Lotto must range 1 to 45. "
        private const val NOT_ASCENDING_ORDER = "[ERROR] Lotto must order in ascending order. "
        private const val NOT_UNIQUE_NUMBER = "[ERROR] Each Lotto number must be unique. "
    }
}
