package lotto.domain

import lotto.Lotto

class Lottos(private val lottos: List<Lotto>) {
    fun matchAgainst(winningNumbers: List<Int>, bonusNumber: BonusNumber): LottoResults {
        val matchResults = lottos.map { it.toMatchResult(winningNumbers, bonusNumber.number()) }
        return LottoResults(matchResults)
    }
}
