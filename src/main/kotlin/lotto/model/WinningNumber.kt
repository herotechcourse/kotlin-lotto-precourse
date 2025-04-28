package lotto.model

class WinningNumber(val winningNumbers: List<Int>, val bonusNumber: Int) {
    init {
        require(winningNumbers.size == 6) { "[ERROR]  winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.toSet().size == 6) { "[ERROR] Lotto must be composed with unique numbers" }
        validateBonusNumber(bonusNumber)
    }

    override fun toString(): String {
        return winningNumbers.toString()
    }

    private fun validateBonusNumber(input: Int) {
        if (winningNumbers.contains(input)) {
            throw IllegalArgumentException("[ERROR] Bonus number must be not included in Winning number")
        }

    }


}