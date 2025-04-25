package lotto

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    fun matchCount(winningNumbers: Lotto): Int {
        return numbers.count { it in winningNumbers.numbers }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

}
