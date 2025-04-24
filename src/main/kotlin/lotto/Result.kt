package lotto

class Result {
    private val winCounts = mutableMapOf(
        Rank.FIRST to 0, Rank.SECOND to 0, Rank.THIRD to 0,
        Rank.FOURTH to 0, Rank.FIFTH to 0, Rank.WITHOUT to 0
    )

    fun add(rank: Rank) {
        winCounts[rank] = winCounts[rank]!! + 1
    }

    fun getProfitRate(): String {
        val totalPrize = winCounts.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
        val totalSpent = winCounts.values.sum() * 1000
        return String.format("%.1f", totalPrize.toDouble() / totalSpent * 100).replace(",", ".")
    }

    fun getWinCounts(): Map<Rank, Int> {
        return winCounts.toMap()
    }
}