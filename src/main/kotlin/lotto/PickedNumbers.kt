package lotto

data class PickedNumbers(
    val winningNumbers: List<Int>,
    val bonusNumber: Int,
) {
    init {
        require(winningNumbers.size == 6) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.toSet().size == 6) { "[ERROR] Winning numbers must not contain duplicates." }
        require(winningNumbers.all { it in 1..45 }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not overlap with winning numbers." }
    }

    fun matchCountOf(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in winningNumbers }
    }

    fun hasBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }
}
