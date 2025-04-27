package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must consist of 6 unique numbers" }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> {
        return this.numbers.sorted()
    }

    fun contains(number: Int): Boolean {
        return this.getNumbers().contains(number)
    }

    fun matchCount(other: Lotto): Int {
        return this.getNumbers().count { it in other.getNumbers() }
    }
}
