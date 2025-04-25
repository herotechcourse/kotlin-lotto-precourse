package lotto.domain

import lotto.Lotto

class WinningResult(private val ranks: List<Rank>) {

    fun getStatistics(): Map<Rank, Int> {
        return ranks.groupingBy { it }.eachCount()
    }

    fun getCountOf(rank: Rank): Int {
        return ranks.count { it == rank }
    }

    companion object {
        fun of(lottos: List<Lotto>, winningNumber: WinningNumber): WinningResult {
            val ranks = lottos.map { winningNumber.match(it) }
            return WinningResult(ranks)
        }
    }
}
