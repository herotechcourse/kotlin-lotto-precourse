package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all {it in 1..45}) { "[ERROR] Numbers must be between 1 and 45." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must not contain duplicates." }
    }

    fun compare(other: Lotto ): Int {
        return numbers.count { it in other.numbers }
    }

    fun containsNumber(number: Int): Boolean {
        return number in numbers
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
