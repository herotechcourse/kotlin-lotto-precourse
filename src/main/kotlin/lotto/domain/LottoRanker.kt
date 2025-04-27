package lotto.domain

import lotto.Lotto
import lotto.constants.LottoConstants
import lotto.constants.LottoRank
import kotlin.math.round

class LottoRanker {
    fun rankLotto(lottos: List<Lotto>, winningNumbers: Set<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        return lottos.groupingBy { lotto ->
            lotto.match(winningNumbers, bonusNumber)
        }.eachCount()
    }

    fun calculateProfit(lottos: List<Lotto>, statistics: Map<LottoRank, Int>): Double {
        val totalPrize = statistics.entries.sumOf { (rank, count) -> rank.prize * count }
        val totalSpent = lottos.size * LottoConstants.TICKET_PRICE

        val profitRate = (totalPrize / totalSpent.toDouble()) * 100
        return (round(profitRate * 10) / 10)
    }
}