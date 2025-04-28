package lotto.service

import lotto.Lotto
import lotto.domain.PrizeRank
import lotto.domain.WinningLotto
import kotlin.Int

class LottoResultCalculator(private val userLottos: List<Lotto>, private val winningLotto: WinningLotto) {

    private val prizeMap = mutableMapOf<PrizeRank, Int>(
        PrizeRank.FIFTH to 0,
        PrizeRank.FOURTH to 0,
        PrizeRank.THIRD to 0,
        PrizeRank.SECOND to 0,
        PrizeRank.FIRST to 0
    )

    fun countRanks(): Map<PrizeRank, Int> {
        for (userLotto in userLottos) {
            val matchResult: Pair<Int, Boolean> = userLotto.matchNumbers(winningLotto)
            val result = PrizeRank.of(matchResult.first, matchResult.second)
            prizeMap[result] = prizeMap.getOrDefault(result, 0) + 1
        }
        return prizeMap
    }
}