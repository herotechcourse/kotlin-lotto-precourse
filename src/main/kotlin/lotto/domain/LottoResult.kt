import lotto.domain.Prize

class LottoResult( val statistics: Map<Prize, Int>) {
    fun totalWinnings(): Int {
        return statistics.entries.sumOf { (prize, count) -> prize.reward * count }
    }

    fun profitRate(totalPurchaseAmount: Int): Double {
        val totalWinnings = totalWinnings()
        return (totalWinnings.toDouble() / totalPurchaseAmount) * 100
    }
}
