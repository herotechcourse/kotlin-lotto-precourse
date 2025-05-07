package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be in the range of 1 to 45" }
    }

    fun prizeCount(winningNumbers: Lotto, bonusNumber: Int): Int {
        val matchCount = matchCount(winningNumbers)
        return when {
            matchCount == 6 -> 1
            matchCount == 5 && contains(bonusNumber) -> 2
            matchCount == 5 && !contains(bonusNumber) -> 3
            matchCount == 4 -> 4
            matchCount == 3 -> 5
            else -> 0
        }
    }

    private fun matchCount(winningNumbers: Lotto): Int {
        return numbers.count { it in winningNumbers.numbers }
    }

    fun contains(number: Int): Boolean {
        return number in numbers
    }

    fun getSortedNumbers(): List<Int> = numbers.sorted()
}
