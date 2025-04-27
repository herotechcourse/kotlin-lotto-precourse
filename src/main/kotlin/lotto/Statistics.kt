package lotto

interface Statistics {
    fun calculateResult(tickets: List<Lotto>): Map<Rank, Int>
    fun calculateProfitRate(purchaseAmount: Int): Double
}

class StatisticsImpl(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) : Statistics {
    private val results = mutableMapOf<Rank, Int>()

    override fun calculateResult(tickets: List<Lotto>): Map<Rank, Int> {
        tickets.forEach { ticket ->
            val matchCount = ticket.matchCount(winningNumbers)
            val hasBonus = ticket.containsBonus(bonusNumber)
            val rank = Rank.determine(matchCount, hasBonus)
            if (rank != Rank.NONE) {
                results[rank] = results.getOrDefault(rank, 0) + 1
            }
        }
        return results.toMap()
    }

    override fun calculateProfitRate(purchaseAmount: Int): Double {
        val totalPrize = results.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
}
