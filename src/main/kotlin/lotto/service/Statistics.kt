package lotto.service

import lotto.domain.Rank
import java.util.Locale


class Statistics(
    private val rankCounts: Map<Rank, Int>,
    private val purchaseAmount: Int
) {

    fun totalPrize(): Int =
        rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }

    fun profitRate(): Double {
        if (purchaseAmount == 0) return 0.0
        val roi = (totalPrize().toDouble() / purchaseAmount) * 100
        return String.format(Locale.US, "%.1f", roi).toDouble()
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.appendLine("Lotto result statistics:").appendLine("---")
        Rank.values().filter { it.isWinning() }.forEach { rank ->
            val count = rankCounts[rank] ?: 0
            builder.appendLine(rank.description(count))
        }
        builder.appendLine("Total return rate is ${profitRate()}%.")
        return builder.toString()
    }

    companion object {
        fun from(ranks: List<Rank>, purchaseAmount: Int): Statistics {
            val counts = Rank.values().associateWith { rank -> ranks.count { it == rank } }
            return Statistics(counts, purchaseAmount)
        }
    }
}
