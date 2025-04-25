package lotto

import java.util.*

class Lotto(private val numbers: List<Int>, val price: Int = 1000) {
    init {
        require(numbers.size == 6) { ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE.errorMessage }
        require(numbers.toSet().size == numbers.size) { ExceptionMessage.DUPLICATE_LOTTO_NUMBER.errorMessage }
        numbers.forEach {
            require(it in 1..45) { ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.errorMessage }
        }
    }

    fun getNumbers(): List<Int> {
        return Collections.unmodifiableList(numbers)
    }
}
