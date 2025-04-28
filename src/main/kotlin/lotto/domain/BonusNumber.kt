package lotto.domain

import lotto.LottoConstants.MAX_NUMBER
import lotto.LottoConstants.MIN_NUMBER
import lotto.domain.ErrorMessages.INVALID_BONUS_NUMBER_DUPLICATED
import lotto.domain.ErrorMessages.INVALID_NUMBERS_RANGE

data class BonusNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER .. MAX_NUMBER) { INVALID_NUMBERS_RANGE }
    }

    fun requireNotDuplicated(winning: WinningNumbers) {
        require(number !in winning.numbers) { INVALID_BONUS_NUMBER_DUPLICATED }
    }
}
