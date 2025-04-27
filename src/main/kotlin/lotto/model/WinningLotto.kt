package lotto.model

import lotto.Lotto

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) {
            "[ERROR] Bonus number must be between $LOTTO_NUMBER_MIN and $LOTTO_NUMBER_MAX."
        }
        require(bonusNumber !in lotto.numbers()) {
            "[ERROR] Bonus number must not duplicate winning numbers."
        }
    }

    fun match(lotto: Lotto): MatchRank {
        val matchedCount = this.lotto.matchCount(lotto)
        val bonusMatched = bonusNumber in lotto.numbers()
        return MatchRank.of(matchedCount, bonusMatched)
    }
}
