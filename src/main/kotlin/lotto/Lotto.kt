package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun matchCount(winningNumbers: List<Int>) = numbers.count { it in winningNumbers }
    fun containsBonus(bonus: Int) = numbers.contains(bonus)
    fun getNumbers(): List<Int> = numbers.sorted()
}

