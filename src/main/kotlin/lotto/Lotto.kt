package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun countMatch(winningNumbers: List<Int>): Int {
        return numbers.count { winningNumbers.contains(it) }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
