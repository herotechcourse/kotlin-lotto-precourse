package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.size == numbers.toSet().size) { "[ERROR] Lotto numbers must not contain duplicates." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }

    }
    fun getNumbers(): List<Int> = numbers.sorted()

    fun matchCount(winningNumbers: List<Int>): Int =
        numbers.count { it in winningNumbers }
    fun hasBonus(bonusNumber: Int): Boolean =
        numbers.contains(bonusNumber)
}
