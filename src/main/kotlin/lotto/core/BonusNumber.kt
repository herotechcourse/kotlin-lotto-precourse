package lotto.core

import lotto.core.constant.ErrorMessage.ErrorMessages.LOTTO_BONUS_NUMBER_RANGE_ERROR
import lotto.core.constant.LottoConstants.MAX_LOTTO_NUMBER
import lotto.core.constant.LottoConstants.MIN_LOTTO_NUMBER


data class BonusNumber(val value: Int) {
    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { LOTTO_BONUS_NUMBER_RANGE_ERROR }
    }
}