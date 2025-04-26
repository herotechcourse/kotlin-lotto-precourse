package lotto.domain

import lotto.Lotto
import java.text.DecimalFormat

class LottoResult(
    private val tickets: List<Lotto>,
    private val winningNumbers: WinningNumbers
) {
    private val rankCounts: Map<Rank, Int> = calculateRankCounts()
    private val totalPrize: Long = calculateTotalPrize()
    private val profitRate: Double = calculateProfitRate()

    private fun calculateRankCounts(): Map<Rank, Int> {
        val counts = mutableMapOf<Rank, Int>()
        Rank.values().forEach { counts[it] = 0 }
        
        tickets.forEach { ticket ->
            val rank = winningNumbers.match(ticket)
            if (rank != Rank.NONE) {
                counts[rank] = counts[rank]!! + 1
            }
        }
        
        return counts
    }

    private fun calculateTotalPrize(): Long {
        return rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    private fun calculateProfitRate(): Double {
        val totalCost = tickets.size * TICKET_PRICE
        return totalPrize.toDouble() / totalCost * 100
    }

    fun getRankCounts(): Map<Rank, Int> {
        return rankCounts
    }

    fun getTotalPrize(): Long {
        return totalPrize
    }

    fun getFormattedProfitRate(): String {
        val df = DecimalFormat("#,##0.0")
        return df.format(profitRate)
    }

    companion object {
        const val TICKET_PRICE = 1000
    }
}
