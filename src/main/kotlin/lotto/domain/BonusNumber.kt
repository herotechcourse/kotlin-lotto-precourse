package lotto.domain

import lotto.InputHandler.Companion.BONUS_NUMBER_DUPLICATE
import lotto.InputHandler.Companion.LOTTO_NUMBER_ENDS
import lotto.InputHandler.Companion.LOTTO_NUMBER_STARTS
import lotto.InputHandler.Companion.WINNING_NUMBER_OVER_RANGE

class BonusNumber(val number: Int, winningNumbers: List<Int>) {
    init {
        require(checkRange(number)) { WINNING_NUMBER_OVER_RANGE }
        require(checkDuplicates(number, winningNumbers)) { BONUS_NUMBER_DUPLICATE }
    }

    private fun checkRange(number: Int) = number in LOTTO_NUMBER_STARTS..LOTTO_NUMBER_ENDS

    private fun checkDuplicates(bonusNumber: Int, winningNumbers: List<Int>) = !winningNumbers.contains(bonusNumber)
}