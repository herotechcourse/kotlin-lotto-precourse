package lotto

class Statistic(private val ranks: List<Rank?>) {
    fun sortedRankCounts(): Map<Rank, Int> {
        val countMap = ranks.groupingBy { it }.eachCount()
        return Rank.entries.associateWith { countMap[it] ?: 0 }
    }

    fun returnRate() = totalPrizeInKRW().toDouble() / (ranks.size * 1000)

    fun totalPrizeInKRW() = ranks.mapNotNull { it?.prizeInKRW }.sum()
}
