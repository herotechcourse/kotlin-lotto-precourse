package lotto.domain

class LottoResult(private val rankCounts: Map<Rank, Int>) {
    companion object {
        fun evaluate(tickets: List<LottoTicket>, winning: Set<Int>, bonus: Int): LottoResult {
            val result = mutableMapOf<Rank, Int>()

            for (ticket in tickets) {
                val match = ticket.matchCount(winning)
                val bonusMatch = ticket.containsBonus(bonus)
                val rank = Rank.from(match, bonusMatch)
                if (rank != null) {
                    result[rank] = result.getOrDefault(rank, 0) + 1
                }
            }
            return LottoResult(result)
        }
    }

    fun getRankCounts(): Map<Rank, Int> = rankCounts.toSortedMap(compareByDescending { it.prize })

    fun totalPrize(): Int = rankCounts.entries.sumOf { it.key.prize * it.value }
}
