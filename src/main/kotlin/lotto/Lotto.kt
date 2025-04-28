package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Duplicate numbers are not allowed." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
