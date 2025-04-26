package lotto.domain

class LottoResult(val statistics: Map<PrizeCategory, Int>) {

    fun totalWinnings(): Int {
        return statistics.entries.sumOf { (prizeCategory, count) -> prizeCategory.prizeAmount * count }
    }

    fun profitRate(totalPurchaseAmount: Int): Double {
        val totalWinnings = totalWinnings()
        return (totalWinnings.toDouble() / totalPurchaseAmount) * 100
    }

    fun printStatistics() {
        println("Winning Statistics")
        println("---")
        PrizeCategory.entries.forEach { prize ->
            val count = statistics.getOrDefault(prize, 0)
            println("${prize.description} (${prize.prizeAmount} KRW) – $count tickets")
        }
    }
}
