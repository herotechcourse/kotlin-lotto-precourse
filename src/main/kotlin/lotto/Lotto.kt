package lotto

import lotto.domain.PrizeRank

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1 .. 45 }) { "[ERROR] Lotto numbers must be between 1 and 45."}
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique" }
    }

    // TODO: Implement additional functions
    fun getNumbers(): List<Int> = numbers.sorted()

    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.count {it in winningNumbers}
    }

    fun hasBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber in numbers
    }

    fun determinePrize(winningNumbers: List<Int>, bonusNumber: Int): PrizeRank {
        val matchCount = countMatches(winningNumbers)
        val hasBonus = hasBonusNumber(bonusNumber)
        return PrizeRank.determineRank(matchCount, hasBonus)
    }
}
