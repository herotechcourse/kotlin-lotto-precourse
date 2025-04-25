package lotto.domain

import lotto.Lotto

class BonusNumber(private val number: Int) {

    init {
        require(number in 1..45) { BONUS_NUMBER_OUT_OF_RANGE }
    }

    fun validateNotDuplicateWith(lotto: Lotto) {
        require(!lotto.numbers().contains(number)) {
            BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER
        }
    }

    fun value(): Int = number

    companion object {
        const val BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] Bonus number must be between 1 and 45."
        const val BONUS_NUMBER_DUPLICATED_WITH_WINNING_NUMBER = "[ERROR] Bonus number must not duplicate any winning number."
    }
}
