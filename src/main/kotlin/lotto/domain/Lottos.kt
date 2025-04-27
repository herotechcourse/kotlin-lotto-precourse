package lotto.domain

import lotto.Lotto

class Lottos(private val lottos: List<Lotto>) {
    fun matchAgainst(winningNumbers: Lotto, bonusNumber: BonusNumber): LottoResults {
        val matchResults = lottos.map { it.toMatchResult(winningNumbers.numbers(), bonusNumber.number()) }
        return LottoResults(matchResults)
    }
}
