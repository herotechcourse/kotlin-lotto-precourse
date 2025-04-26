package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        validateNumbers(numbers)
    }

    private fun validateNumbers(numbers: List<Int>) {
        require(numbers.size == 6) { "Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "Numbers must be between 1 and 45." }
        require(numbers.distinct().size == 6) { "Numbers must be unique." }
    }

    fun contains(number: Int): Boolean = numbers.contains(number)
    fun matchCount(other: Lotto): Int = numbers.count { other.numbers.contains(it) }
    fun getNumbers(): List<Int> = numbers.sorted()
}
