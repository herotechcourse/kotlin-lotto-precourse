package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must not have duplicates." }
    }

    // TODO: Implement additional functions

    fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.toString()
    }
}