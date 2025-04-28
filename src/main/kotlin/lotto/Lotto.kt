package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    /**
     * Returns the ticket's numbers sorted in ascending order.
     */
    fun getNumbers(): List<Int> = numbers.sorted()
}
