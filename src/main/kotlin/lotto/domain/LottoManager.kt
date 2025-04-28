package lotto.domain

import lotto.Lotto
import lotto.Rank

class LottoManager(private val lottos: List<Lotto>) {

    fun matchLottos(winningLotto: WinningLotto): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()

        for (lotto in lottos) {
            val matchCount = lotto.matchCount(winningLotto.getWinningNumbers().toSet())
            val hasBonus = lotto.containsBonusNumber(winningLotto.getBonusNumber())
            val rank = Rank.from(matchCount, hasBonus)

            // 디버깅용: matchCount와 result 상태 출력
            println("matchCount: $matchCount, rank: $rank, result: $result")
            result[rank] = (result[rank] ?: 0) + 1

        }

        return result
    }
}
