package lotto.domain

class WinningNumbers(private val numbers: List<Int>, private val bonus: Int) {
    init {
        require(numbers.size == 6) { "[ERROR] Must enter exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Numbers must be between 1 and 45." }

        require(bonus in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!numbers.contains(bonus)) { "[ERROR] Bonus number must not be in winning numbers." }
    }

    fun getMainNumbers(): Set<Int> = numbers.toSet()

    fun getBonus(): Int = bonus
}