package lotto

import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_BONUS_NUMBER_IN_LOTTO
import lotto.constants.ErrorMessageConstants.ERROR_MESSAGE_INVALID_BONUS_NUMBER_LIMIT

class BonusNumber(private val bonusNumber: Int, lotto: Lotto) {
    init {
        require(bonusNumber in 1..45) { ERROR_MESSAGE_INVALID_BONUS_NUMBER_LIMIT }
        require(bonusNumber !in lotto.getLottoNumber()) { ERROR_MESSAGE_BONUS_NUMBER_IN_LOTTO }
    }

    fun getBonusNumber():Int{
        return bonusNumber
    }
}