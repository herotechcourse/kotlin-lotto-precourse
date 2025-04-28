package lotto.domain.winning

import lotto.Lotto

object WinningDeterminer {
    fun determineMatchCount(randomLotto: Lotto, winningNumbers: WinningNumbers) =
        winningNumbers.countMatches(randomLotto)

    fun determineBonusMatch(randomLotto: Lotto, bonusNumber: BonusNumber): Boolean =
        bonusNumber.isMatched(randomLotto)
}