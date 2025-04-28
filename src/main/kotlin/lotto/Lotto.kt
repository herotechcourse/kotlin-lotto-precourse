package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Lotto numbers must be unique." }
    }

    // TODO: Implement additional functions

    fun getNumbers(): List<Int> {
        return numbers
    }
}