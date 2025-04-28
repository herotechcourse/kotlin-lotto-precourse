package lotto.domain

import kotlin.math.round

class LottoStatistics(
    private val results: List<LottoResult>,
    private val purchaseAmount: Int
) {
    private val totalPrize: Long = results.sumOf { it.prize }

    fun count(rank: LottoResult): Int =
        results.count { it == rank }

    val profitRate: Double
        get() {
            val raw = totalPrize.toDouble() / purchaseAmount * 1000
            return round(raw * 10) / 10.0
        }
}
