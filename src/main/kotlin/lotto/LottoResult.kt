package lotto

class LottoResult(private val ranks: List<Rank>) {

    fun getRankCounts(): Map<Rank, Int> {
        return ranks.groupingBy { it }.eachCount()
    }

    fun totalPrize(): Int {
        return ranks.sumOf { it.prize }
    }
}