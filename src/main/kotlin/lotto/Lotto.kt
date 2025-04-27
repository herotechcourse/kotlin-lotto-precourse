package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }

    fun matchCount(winningNumbers: Set<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

}
