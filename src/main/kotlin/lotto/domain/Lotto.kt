package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun matchCount(other: List<Int>): Int {
        return numbers.toSet().intersect(other.toSet()).size
    }

    // TODO: Implement additional functions
}
