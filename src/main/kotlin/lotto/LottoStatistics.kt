
package lotto

import kotlin.math.roundToLong


class LottoStatistics(
    private val results: List<LottoRank>,
    private val purchaseAmount: Int
) {

    fun countByRank(): Map<LottoRank, Int> =
        results.groupingBy { it }.eachCount()


    fun totalPrize(): Long =
        results.sumOf { it.prize }


    fun returnRate(): Double {
        if (purchaseAmount == 0) return 0.0
        val rate = totalPrize().toDouble() / purchaseAmount * 100
        return (rate * 10).roundToLong() / 10.0
    }
}
