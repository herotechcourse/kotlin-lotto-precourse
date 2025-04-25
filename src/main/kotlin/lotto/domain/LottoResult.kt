package lotto.domain

import lotto.Lotto
class LottoResult(private val rankCount: Map<Rank, Int>) {

    fun countOf(rank: Rank): Int = rankCount[rank] ?: 0

    fun totalReward(): Int =
        rankCount.entries.sumOf { (rank, count) -> rank.prize * count }

    fun profitRate(purchaseAmount: Int): Double {
        val reward = totalReward()
        return ((reward.toDouble() / purchaseAmount) * 100).let {
            String.format("%.1f", it).toDouble()
        }
    }

    companion object {
        fun of(lottoes: Lottoes, winningLotto: WinningLotto): LottoResult {
            val ranks = lottoes.getTickets().map { lotto ->
                val match = lotto.matchCount(winningLotto.numbers)
                val hasBonus = lotto.hasBonus(winningLotto.bonusNumber)
                Rank.of(match, hasBonus)
            }

            val countByRank = ranks.groupingBy { it }.eachCount()
            return LottoResult(countByRank)
        }
    }
}