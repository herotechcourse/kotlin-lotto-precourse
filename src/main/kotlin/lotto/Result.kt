package lotto

class Result(private val ranks: List<Rank>) {
    fun sortedRankCounts(): Map<Rank, Int> {
        val countMap = ranks.groupingBy { it }.eachCount()
        return Rank.entries.associateWith { countMap[it] ?: 0 }
    }

    fun returnRate() = ranks.size * 1000 / totalPrizeInKRW().toDouble()

    fun totalPrizeInKRW() = ranks.sumOf { it.prizeInKRW }
}
