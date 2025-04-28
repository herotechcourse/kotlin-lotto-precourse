package lotto.domain

class WinningNumbers(val numbers: List<Int>, val bonusNumber: Int) {
    init {
        validateNumbers()
        validateBonusNumber()
    }

    private fun validateNumbers() {
        require(numbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Winning numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    private fun validateBonusNumber() {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!numbers.contains(bonusNumber)) { "[ERROR] Bonus number must not be included in the winning numbers." }
    }
}