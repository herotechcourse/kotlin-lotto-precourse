package lotto

import java.util.*

class Lotto(private val numbers: List<Int>, val price: Int = 1000) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) {"[ERROR] Lotto numbers must consist of unique numbers."}
        numbers.forEach {
            require(it in 1..45) {"[ERROR] Lotto numbers must in the range from 1 to 45"}
        }
    }

    fun getNumbers(): List<Int> {
        return Collections.unmodifiableList(numbers)
    }
}
