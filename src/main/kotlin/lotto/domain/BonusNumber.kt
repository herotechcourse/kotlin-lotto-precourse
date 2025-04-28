package lotto.domain

import lotto.constant.Constants

class BonusNumber(
    val number: LottoNumber,
    winningNumbers: WinningNumbers
) {
    init {
        require(!winningNumbers.contains(number)) {
            Constants.ERROR_DUPLICATE_BONUS_NUMBER
        }
    }

    override fun toString(): String = number.toString()
}