package lotto.domain

class LottoStatistics(
    private val results: List<LottoResult>,
    private val purchaseAmount: Int
) {
    private val totalPrize: Long = results.sumOf { it.prize }
    private val ticketCount: Int = purchaseAmount / 1_000

    fun count(rank: LottoResult): Int =
        results.count { it == rank }

    val profitRate: Double
        get() = if (ticketCount > 0)
            totalPrize.toDouble() / ticketCount
        else
            0.0

    val returnRate: Double
        get() = if (purchaseAmount > 0)
            totalPrize.toDouble() / purchaseAmount * 100
        else
            0.0
}
