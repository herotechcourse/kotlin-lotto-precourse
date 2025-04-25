package lotto.model

import lotto.Lotto
import lotto.error.ExceptionMessage

class WinningLotto(val winningLotto: Lotto, val bonusNumber: Int) {
    init {
        require(bonusNumber in 1..45) { ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE}
    }
}