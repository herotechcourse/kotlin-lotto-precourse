package lotto.domain

import lotto.Lotto

fun determineRankDummy(matchCount: Int, bonusMatched: Boolean): Rank {
    if (matchCount == 6)
        return Rank.FIRST
    else if (matchCount == 5 && bonusMatched)
        return Rank.SECOND
    else if (matchCount == 5 && !bonusMatched)
        return Rank.THIRD
    else if (matchCount == 4)
        return Rank.FOURTH
    else if (matchCount == 3)
        return Rank.FIFTH
    else
        return Rank.MISS
}

/**
 *  [ Background ]
 *  count()
 *  = Iterate through a list and counts how many items match,
 *      the given condition, such as "{ it in winningNumbers }" like below.
 *      And returns the number of elements that satisfy the condition.
 */
fun matchLottos(
    lottos : List<Lotto>,
    winningNumbers : List<Int>,
    bonusNumber : Int
) : List<Rank> {
    return lottos.map { lotto ->
        val sixLottoNumbers = lotto.getNumbers()
        val matchCount = sixLottoNumbers.count { it in winningNumbers }
        val bonusMatched = bonusNumber in sixLottoNumbers
        determineRankDummy(matchCount, bonusMatched)
    }
}