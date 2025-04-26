package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto numbers must be unique." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
