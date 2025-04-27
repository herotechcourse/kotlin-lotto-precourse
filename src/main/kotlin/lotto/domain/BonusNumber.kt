package lotto.domain

import lotto.Lotto

class BonusNumber(inputBonusNumber: String, winningNumbers: WinningNumbers) {

    val number: Int

    init {
        require(inputBonusNumber.isNotBlank()) { Lotto.ERROR_INPUT_EMPTY }
        number = validateBonus(inputBonusNumber, winningNumbers)
    }

    private fun validateBonus(input: String, winningNumbers: WinningNumbers): Int {
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException(Lotto.ERROR_NOT_VALID_NUMBER)

        require(bonus in Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER) { Lotto.ERROR_NOT_IN_RANGE }
        require(!winningNumbers.contains(bonus)) { ERROR_BONUS_NOT_UNIQUE }

        return bonus
    }

    companion object {
        private const val ERROR_BONUS_NOT_UNIQUE = "[ERROR] Bonus number must not be any of winning numbers."
    }
    
}