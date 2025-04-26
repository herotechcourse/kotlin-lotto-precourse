package lotto.domain

class LottoResult(private val prizeCounts: Map<Prize, Int>) {
    fun getPrizeCount(prize: Prize): Int = prizeCounts[prize] ?: 0
    fun getTotalWinnings(): Int =
            prizeCounts.entries.sumOf { (prize, count) -> prize.amount * count }
}
