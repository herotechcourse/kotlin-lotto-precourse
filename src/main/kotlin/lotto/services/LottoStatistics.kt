package lotto.services

import lotto.Lotto
import lotto.domain.Rank

class LottoStatistics(private val lottos: List<Lotto>, private val winningLotto: Lotto, private val bonusNumber: Int) {
    val result: MutableMap<Rank, Int> = mutableMapOf()

    fun calculate() {
        lottos.forEach { lotto ->
            val matchCount = lotto.matchCount(winningLotto)
            val bonusMatch = lotto.containBonus(bonusNumber)
            val rank = Rank.from(matchCount, bonusMatch)

            if (rank != null) {
                result[rank] = result.getOrDefault(rank, 0) + 1
            }
        }


    }

    fun calculateProfitRate(budget: Int): Double {
        val totalPrize = result.entries.sumOf { (rank, count) -> rank.prize * count }
        val rate = (totalPrize.toDouble() / budget) * 100
        return String.format("%.1f", rate).toDouble()
    }
}