package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> = numbers.toList()
}
