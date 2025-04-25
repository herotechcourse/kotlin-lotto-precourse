package lotto.model

import lotto.Lotto

class WinnerLotto(private val lotto: Lotto, private val bonusNumber: Int) {
    init {
        require(bonusNumber !in lotto.getLottoNumbers()) { "Bonus Number must be a unique number" }
    }

    fun getLottoNumbers(): List<Int> = lotto.getLottoNumbers()

    fun getBonusNumber(): Int = bonusNumber
}