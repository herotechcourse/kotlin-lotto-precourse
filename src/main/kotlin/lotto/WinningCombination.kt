package lotto

class WinningCombination (
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    val winningNumberList: List<Int> get() = winningNumbers
}