package lotto.service

import lotto.Lotto
import lotto.domain.Rank

fun matchLottos(
    lottos : List<Lotto>,
    winningNumbers : List<Int>,
    bonusNumber : Int
) : List<Rank> {
    return lottos.map { lotto ->
        val matchCount = lotto.countMatchedNumbers(winningNumbers)
        val bonusMatched = lotto.isBonusNumber(bonusNumber)
        Rank.determine(matchCount, bonusMatched)
    }
}
