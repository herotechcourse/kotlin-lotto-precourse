package lotto.model

import lotto.Lotto
import lotto.validator.InputValidator

class WinningLotto(
    private val mainLotto: Lotto,
    private val bonusNumber: Int
) {
    init {
        InputValidator.numberIsRange(bonusNumber)
        InputValidator.noDuplicateBonusNumber(bonusNumber, mainLotto)
    }
    
}