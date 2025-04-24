package lotto.domain

import lotto.Lotto

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!numbers.contains(bonusNumber)) { "[ERROR] Bonus number must not duplicate a winning number." }
    }

    fun countMatches(lotto: Lotto): Int {
        return lotto.numbers().count { numbers.contains(it) }
    }

    fun isBonusMatch(lotto: Lotto): Boolean {
        return lotto.numbers().contains(bonusNumber)
    }
}