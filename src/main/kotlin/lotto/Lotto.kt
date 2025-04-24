package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }
    fun getNumbers(): List<Int> = numbers.sorted()

    fun matchingCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
