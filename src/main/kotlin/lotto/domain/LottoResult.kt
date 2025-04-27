package lotto.domain

class LottoResult {
    private val results = mutableMapOf<Rank, Int>()

    fun addResult(rank: Rank) {
        results[rank] = (results[rank] ?: 0) + 1
    }

    fun getResult(): Map<Rank, Int> = results.toMap()

    fun calculateProfit(totalPurchase: Int): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        return (totalPrize.toDouble() / totalPurchase) * 100
    }
}