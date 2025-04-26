package lotto.domain

import lotto.Lotto

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must not contain duplicates." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in numbers) { "[ERROR] Bonus number must not be included in the winning numbers." }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }

    fun match(lotto: Lotto): Rank {
        val matchCount = lotto.countMatches(numbers)
        val hasBonus = lotto.containsNumber(bonusNumber)
        
        return Rank.getRank(matchCount, matchCount == 5 && hasBonus)
    }
}
