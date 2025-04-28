package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    override fun toString(): String {
        return numbers.sorted().joinToString(", ", "[", "]")
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }
}
