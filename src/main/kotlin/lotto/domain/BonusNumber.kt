package lotto.domain

import lotto.domain.ErrorMessages.INVALID_BONUS_NUMBER_DUPLICATED
import lotto.domain.ErrorMessages.INVALID_NUMBERS_RANGE

data class BonusNumber(val number: Int) {
    init {
        require(number in 1 .. 45) { INVALID_NUMBERS_RANGE }
    }

    fun requireNotDuplicated(winning: WinningNumbers) {
        require(number !in winning.numbers) { INVALID_BONUS_NUMBER_DUPLICATED }
    }
}
