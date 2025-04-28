package lotto.domain

class WinningNumbers(
    private val mainNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(mainNumbers.size == 6 && mainNumbers.toSet().size == 6) {
            "[ERROR] Winning numbers must contain exactly 6 unique numbers."
        }
        require(mainNumbers.all { it in 1..45 }) {
            "[ERROR] Winning numbers must be between 1 and 45."
        }
        require(bonusNumber in 1..45) {
            "[ERROR] Bonus number must be between 1 and 45."
        }
        require(bonusNumber !in mainNumbers) {
            "[ERROR] Bonus number must not duplicate winning numbers."
        }
    }

    fun mainNumbers(): List<Int> = mainNumbers.toList()
    fun bonusNumber(): Int = bonusNumber
}
