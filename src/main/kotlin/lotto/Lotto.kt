package lotto

import lotto.exception.ExceptionMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { ExceptionMessage.INVALID_LOTTO_SIZE.message }
        require(numbers.all { it in 1..45 }) { ExceptionMessage.INVALID_LOTTO_RANGE.message }
        require(numbers.distinct().size == 6) { ExceptionMessage.DUPLICATE_LOTTO_NUMBERS.message }
    }

    fun getNumbers() : List<Int> = numbers.sorted()

    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun containsNumber(number: Int): Boolean {
        return numbers.contains(number)
    }
}
