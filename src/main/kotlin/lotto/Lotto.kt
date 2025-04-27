package lotto

import lotto.util.InputValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }

        val uniqueNums = numbers.toSet()
        if (uniqueNums.size != numbers.size) {
            throw IllegalArgumentException("[ERROR] Duplicate numbers.")
        }

        require(numbers.all { it in 1..45}) { "[ERROR] Invalid number in range [1, 45]."}
    }

    fun countMatchingNumbers(otherNumbers: List<Int>): Int {
        val thisSet = numbers.toSet()
        return otherNumbers.count { thisSet.contains(it) }
    }

    fun contains(number: Int): Boolean {
        return this.numbers.contains(number)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
