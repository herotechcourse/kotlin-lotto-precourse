package lotto.domain

import lotto.Lotto

class LottoResult private constructor(
    private val results: Map<Rank, Int>
) {
    companion object {
        fun of(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): LottoResult {
            val map = mutableMapOf<Rank, Int>()

            for (ticket in tickets) {
                val match = ticket.matchCount(winningNumbers)
                val matchBonus = ticket.containsBonus(bonus)
                val rank = Rank.of(match, matchBonus)
                map[rank] = map.getOrDefault(rank, 0) + 1
            }

            return LottoResult(map)
        }
    }

    fun getResults(): Map<Rank, Int> = results

    fun profitRate(amount: Int): String {
        val totalPrize = results.entries.sumOf { it.key.prize * it.value }
        val rate = totalPrize.toDouble() / amount * 100
        return String.format("%.1f", rate)
    }
}
