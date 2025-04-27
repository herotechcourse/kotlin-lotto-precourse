package lotto.domain

class WinningNumbersFactory {
    fun create(winningNumbers: List<Int>, bonusNumber: Int): WinningNumbers {
        val winningNumber = WinningNumber(winningNumbers)
        val bonusNum = BonusNumber(bonusNumber, winningNumbers)
        return WinningNumbers(winningNumber, bonusNum)
    }
}
