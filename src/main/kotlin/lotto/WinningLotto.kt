package lotto

class WinningLotto() {
    private var winningNumbers: MutableList<Int> = mutableListOf()
    private var bonusNumber: Int = -1

    fun registerWinningNumbers(input: List<Int>) {
        winningNumbers.addAll(input)
    }

    fun registerBonusNumber(lastWeekBonusNumber: String) {
        bonusNumber = lastWeekBonusNumber.toInt()
    }
}