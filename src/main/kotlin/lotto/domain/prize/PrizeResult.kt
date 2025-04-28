package lotto.domain.prize

import java.util.*

class PrizeResult(private val result: EnumMap<Rank, Int>) {
    companion object {
        fun create(): PrizeResult {
            val ranks = EnumMap<Rank, Int>(Rank::class.java).apply {
                Rank.values().forEach { put(it, 0) }
            }
            return PrizeResult(ranks)
        }
    }
}