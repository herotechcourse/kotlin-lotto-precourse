package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
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
