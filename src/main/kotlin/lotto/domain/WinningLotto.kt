package lotto.domain

import lotto.common.Constants

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER) { "[ERROR] Bonus number must be between 1 and 45." }
        require(!winningNumbers.contains(bonusNumber)) { "[ERROR] Winning numbers must not contain bonus number." }
        require(winningNumbers.size == Constants.LOTTO_SIZE) { "[ERROR] Winning Lotto must contain exactly 6 numbers." }
        require(winningNumbers.distinct().size == Constants.LOTTO_SIZE) { "[ERROR] Lotto numbers must be unique." }
        require(winningNumbers.all { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun getWinningNumbers(): List<Int> {
        return winningNumbers
    }

    fun getBonusNumber(): Int {
        return bonusNumber
    }
}