package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    fun matchCount(winningNumbers: Set<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }
}
