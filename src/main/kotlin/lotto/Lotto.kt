package lotto

import lotto.util.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "${Constants.ERROR_PREFIX} Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size==6){"${Constants.ERROR_PREFIX} Lotto numbers must not contain duplicate numbers."}
        numbers.forEach{number->
            require(number in 1..45){"${Constants.ERROR_PREFIX} Lotto numbers must be between 1 and 45."}
        }
    }
    fun getNumbers(): List<Int> = numbers.toList()

    fun countMatch(other: Lotto): Int {
        return numbers.count { it in other.getNumbers() }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lotto

        return numbers == other.numbers
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    override fun toString(): String {
        return "$numbers"
    }
}
