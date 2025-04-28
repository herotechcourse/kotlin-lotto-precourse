package lotto.domain.model

import lotto.config.LottoConstants.LOTTO_NUMBER_ENDS
import lotto.config.LottoConstants.LOTTO_NUMBER_STARTS
import lotto.config.Messages

class BonusNumber(val number: Int, winningNumbers: List<Int>) {
    init {
        require(checkRange(number)) { Messages.WINNING_NUMBER_OVER_RANGE }
        require(checkDuplicates(number, winningNumbers)) { Messages.BONUS_NUMBER_DUPLICATE }
    }

    private fun checkRange(number: Int) = number in LOTTO_NUMBER_STARTS..LOTTO_NUMBER_ENDS

    private fun checkDuplicates(bonusNumber: Int, winningNumbers: List<Int>) = !winningNumbers.contains(bonusNumber)
}