package lotto.domain.prize

import lotto.domain.PurchaseAmount
import java.util.*

class PrizeResult(private val result: EnumMap<Rank, Int>) {
    fun addRankBy(matchCount: Int, bonusMatch: Boolean): Int {
        val rank = Rank.find(matchCount, bonusMatch)
        add(rank)

        return count(rank)
    }

    private fun add(rank: Rank) {
        result[rank] = result.getOrDefault(rank, 0) + 1
    }

    fun count(rank: Rank): Int = result[rank] ?: 0

    fun calculateProfitRate(purchaseAmount: PurchaseAmount): Float {
        return sumTotalPrizeAmount() / purchaseAmount.amount().toFloat() * PERCENT
    }

    private fun sumTotalPrizeAmount(): Float {
        val summary = result.entries.sumOf { (rank, count) ->
            rank.multiplyPrizeAmount(count)
        }

        return summary.toFloat()
    }

    companion object {
        private const val PERCENT = 100

        fun create(): PrizeResult {
            val ranks = EnumMap<Rank, Int>(Rank::class.java).apply {
                Rank.values().forEach { put(it, 0) }
            }
            return PrizeResult(ranks)
        }
    }
}