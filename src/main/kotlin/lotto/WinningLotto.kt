package lotto

class WinningLotto() {
    private var winningNumbers: MutableList<Int> = mutableListOf()
    private var bonusNumber: Int = DEFAULT_BONUS_NUMBER

    fun getBonusNumber(): Int {
        return bonusNumber
    }

    fun getWinningNumbers(): List<Int> {
        return winningNumbers
    }

    fun registerWinningNumbers(input: List<Int>) {
        winningNumbers.addAll(input)
    }

    fun registerBonusNumber(lastWeekBonusNumber: Int) {
        bonusNumber = lastWeekBonusNumber
    }

    companion object {
        private const val DEFAULT_BONUS_NUMBER = -1
    }
}