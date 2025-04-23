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

    fun getProfitRate(): String {
        val totalPrize = winCounts.entries.sumOf { (rank, count) ->
            prizeMoney[rank]!! * count
        }
        val totalSpent = winCounts.values.sum() * 1000
        return String.format("%.1f", totalPrize.toDouble() / totalSpent * 100).replace(",", ".")
    }

    fun calculate(): Map<Rank, Int> {
        return winCounts.toMap()
    }

    fun getWinCounts(): Map<Rank, Int> {
        return winCounts.toMap()
    }
}