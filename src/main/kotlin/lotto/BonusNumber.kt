package lotto

import lotto.business.LottoErrorMessage

class BonusNumber(private val number: Int) {
    init {
        require(number in Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER) { LottoErrorMessage.INVALID_BONUS_NUMBER_RANGE.message }
    }

    fun getNumber() = this.number

    companion object {
        fun from(number: String, winningNumber: WinningNumber): BonusNumber {
            require(number.toIntOrNull() != null) { LottoErrorMessage.BONUS_NUMBER_NOT_INTEGER.message }
            require(
                !winningNumber.getNumbers().contains(number.toInt())
            ) { LottoErrorMessage.BONUS_NUMBER_DUPLICATED.message }
            return BonusNumber(number.toInt())
        }
    }
}