package lotto

class LottoResult(private val ranks: List<Ranks>) {

    fun getRankCounts(): Map<Ranks, Int> {
        return ranks.groupingBy { it }.eachCount()
    }

    fun totalPrize(): Int {
        return ranks.sumOf { it.prizeMoney }
    }
}