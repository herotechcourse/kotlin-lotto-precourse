package lotto.model

class LottoResult(private val results: Map<PrizeRank, Int>, private val ticketCount: Int) {
    fun getResult(): Map<PrizeRank, Int> = results

    fun getTotalPrize(): Int {
        return results.entries.sumOf { (rank, count) -> rank.prize * count}
    }

    fun getProfitRate(): Double {
        val totalCost = ticketCount * 1000L
        val totalPrize = getTotalPrize()
        return totalPrize.toDouble()/totalCost * 100
    }
}