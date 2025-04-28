package lotto

import lotto.utils.Constants

class WinningNumbers(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        require(winningNumbers.size == Constants.LOTTO_NUMBER_COUNT) {
            "[ERROR] Must provide exactly ${Constants.LOTTO_NUMBER_COUNT} winning numbers."
        }
        require(winningNumbers.distinct().size == Constants.LOTTO_NUMBER_COUNT) {
            "[ERROR] Winning numbers must be unique."
        }
        require(winningNumbers.all { it in Constants.MINIMUM_VALID_NUMBER..Constants.MAXIMUM_VALID_NUMBER }) {
            "[ERROR] Winning numbers must be between ${Constants.MINIMUM_VALID_NUMBER} and ${Constants.MAXIMUM_VALID_NUMBER}."
        }
        require(bonusNumber in Constants.MINIMUM_VALID_NUMBER..Constants.MAXIMUM_VALID_NUMBER) {
            "[ERROR] Bonus number must be between ${Constants.MINIMUM_VALID_NUMBER} and ${Constants.MAXIMUM_VALID_NUMBER}."
        }
        require(!winningNumbers.contains(bonusNumber)) {
            "[ERROR] Bonus number must not be among winning numbers."
        }
    }

    fun countMatch(ticket: Lotto): Int {
        return ticket.getNumbers().count { it in winningNumbers }
    }

    fun isBonusMatch(ticket: Lotto): Boolean {
        return bonusNumber in ticket.getNumbers()
    }
}