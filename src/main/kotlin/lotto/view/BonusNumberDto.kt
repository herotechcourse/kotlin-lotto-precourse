package lotto.view

import lotto.error.ExceptionMessage

data class BonusNumberDto(val bonusNumber: Int) {
    init {
        require(bonusNumber in 1..45) { ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE.errorMessage }
    }
}