package lotto

import lotto.domain.ErrorMessages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }

        require(numbers.distinct().size == 6) { ErrorMessages.INVALID_WINNING_NUMBERS_DUPLICATED }

        numbers.forEach {
            require(it in 1..45) { ErrorMessages.INVALID_NUMBERS_RANGE }
        }
    }

    fun getNumbers(): List<Int> = numbers
}
