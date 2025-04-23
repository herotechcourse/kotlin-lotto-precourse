package lotto

class Result {
    private val winCounts = mutableMapOf(
        Rank.FIRST to 0, Rank.SECOND to 0, Rank.THIRD to 0,
        Rank.FOURTH to 0, Rank.FIFTH to 0, Rank.WITHOUT to 0
    )

    private val prizeMoney = mapOf(
        Rank.FIRST to 2_000_000_000,
        Rank.SECOND to 30_000_000,
        Rank.THIRD to 1_500_000,
        Rank.FOURTH to 50_000,
        Rank.FIFTH to 5_000,
        Rank.WITHOUT to 0
    )

    fun add(rank: Rank) {
        winCounts[rank] = winCounts[rank]!! + 1
    }

    fun display() {
        println("3 Matches (5,000 KRW) - ${winCounts[Rank.FIFTH]} ticket")
        println("4 Matches (50,000 KRW) - ${winCounts[Rank.FOURTH]} tickets")
        println("5 Matches (1,500,000 KRW) - ${winCounts[Rank.THIRD]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) - ${winCounts[Rank.SECOND]} tickets")
        println("6 Matches (2,000,000,000 KRW) - ${winCounts[Rank.FIRST]} tickets")
    }

    fun getProfitRate(): String {
        val totalPrize = winCounts.entries.sumOf { (rank, count) ->
            prizeMoney[rank]!! * count
        }
        val totalSpent = winCounts.values.sum() * 1000
        return String.format("%.1f", totalPrize.toDouble() / totalSpent * 100)
    }

    fun calculate(): Map<Rank, Int> {
        return winCounts.toMap()
    }
}