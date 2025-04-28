package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        numbers.forEach {
            require(it in 1..45) { "[ERROR] Lotto numbers must be between 1 and 45." }
        }
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    fun countMatches(other: List<Int>): Int = numbers.count { it in other }
    fun containsNumber(number: Int): Boolean = numbers.contains(number)
}
