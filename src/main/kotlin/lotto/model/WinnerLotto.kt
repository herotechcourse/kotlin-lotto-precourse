package lotto.model

import lotto.Lotto

class WinnerLotto(private val lotto: Lotto, private val bonusNumber: Int) {
    init {
        require(bonusNumber !in lotto.getLottoNumbers()) { "Bonus Number must be a unique number" }
        require(bonusNumber in Lotto.FIRST_NUM..Lotto.LAST_NUM) { "Bonus Number must be in ${Lotto.FIRST_NUM..Lotto.LAST_NUM}" }
    }

    fun getLottoNumbers(): List<Int> = lotto.getLottoNumbers()

    fun getBonusNumber(): Int = bonusNumber
}