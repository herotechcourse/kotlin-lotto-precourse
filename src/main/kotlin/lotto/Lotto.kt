package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    override fun toString(): String {
        return numbers.toString()
    }
}
