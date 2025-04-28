package lotto

import lotto.util.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_NUMBER_COUNT) {
            Constants.ERROR_INVALID_NUMBER_COUNT
        }
        require(numbers.toSet().size==Constants.LOTTO_NUMBER_COUNT){
            Constants.ERROR_DUPLICATE_NUMBER
        }
        numbers.forEach{number->
            require(number in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER){
                Constants.ERROR_NUMBER_OUT_OF_RANGE
            }
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
