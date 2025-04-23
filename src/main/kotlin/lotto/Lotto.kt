package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> = numbers
    fun contains(number: Int): Boolean = numbers.contains(number)
}
