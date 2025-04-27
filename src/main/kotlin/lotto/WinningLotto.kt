package lotto

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber in 1..45) { "[ERROR] Bonus number must be between 1 and 45." }
    }

    fun match(lotto: Lotto): LottoRank {
        val matchCount = lotto.matchCount(this.lotto)
        val hasBonus = this.bonusNumber in lotto.getNumbers()
        return LottoRank.find(matchCount, hasBonus)
    }
}