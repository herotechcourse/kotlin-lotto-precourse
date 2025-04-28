package lotto.domain

import lotto.Lotto

class BonusNumber(private val number: Int) {

    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { BONUS_NUMBER_OUT_OF_RANGE }
    }

    fun validateNotDuplicateWith(lotto: Lotto) {
        require(!lotto.numbers().contains(number)) {
            BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER
        }
    }

    fun number(): Int = number

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        const val BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] Bonus number must be between 1 and 45."
        const val BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] Bonus number must not duplicate any winning number."
    }
}
