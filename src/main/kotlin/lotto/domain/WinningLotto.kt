package lotto.domain

import lotto.Lotto

class WinningLotto(
    private val winningNums: List<Int>,
    private val bonusNum: Int
) {
    fun match(purchasedLotto: Lotto): LottoMatchResult {
        val matchCnt = purchasedLotto.countMatchingNumbers(this.winningNums)
        val hasBonus = purchasedLotto.contains(this.bonusNum)
        return LottoMatchResult(matchCnt, hasBonus)
    }
}