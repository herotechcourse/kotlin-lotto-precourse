package lotto.domain.service

import lotto.domain.model.BonusNumber
import lotto.domain.model.WinningNumber
import lotto.domain.model.WinningNumbers

class WinningNumbersFactory {
    fun create(winningNumbers: List<Int>, bonusNumber: Int): WinningNumbers {
        val winningNumber = WinningNumber(winningNumbers)
        val bonusNum = BonusNumber(bonusNumber, winningNumbers)
        return WinningNumbers(winningNumber, bonusNum)
    }
}
