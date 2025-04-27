package lotto

class Statistics {
    val rankCounts = mutableMapOf<Rank,Int>().withDefault { 0 }
    private  var totalWinnings = 0L

    fun addResult(rank:Rank){
        rankCounts[rank] = rankCounts.getValue(rank) + 1
        totalWinnings += rank.prize
    }

    fun calculateProfitRate(totalAmount: Int): String {
        val rate = (totalWinnings.toDouble() / totalAmount) * 100
        return "%.1f".format(rate)
    }

    val profitRate: String
        get() = calculateProfitRate(rankCounts.entries.sumOf { it.value } * 1000)

}