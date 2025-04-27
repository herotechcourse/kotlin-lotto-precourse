package lotto

import lotto.constants.LottoConstants
import lotto.constants.LottoRank
import kotlin.math.round

class LottoRanker(
    private val lottos: List<Lotto>,
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    fun rankLotto(): Map<LottoRank, Int> {
        return lottos.groupingBy { lotto ->
            val matchCount = lotto.getNumbers().count { it in winningNumbers }
            val hasBonus = lotto.getNumbers().contains(bonusNumber)

            LottoRank.findRank(matchCount, hasBonus)
        }.eachCount()
    }

    fun calculateProfit(statistics: Map<LottoRank, Int>): Double {
        val totalPrize = statistics.entries.sumOf { (rank, count) -> rank.prize * count }
        val totalSpent = lottos.size * LottoConstants.TICKET_PRICE

        val profitRate = (totalPrize / totalSpent.toDouble()) * 100
        return (round(profitRate * 10) / 10)
    }
}