package lotto

class LottoResult(private val rankCounts: Map<LottoGrade, Int>) {

    fun getWinCount(rank: LottoGrade): Int {
        return rankCounts.getOrDefault(rank, 0)
    }

    private fun getTotalPrize(): Int {
        return rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    fun calculateReturnRate(purchaseAmount: Int): Double {
        return getTotalPrize().toDouble() / purchaseAmount * 100
    }
}