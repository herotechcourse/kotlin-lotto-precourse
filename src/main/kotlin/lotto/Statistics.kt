package lotto

class Statistics {
    val rankCounts = mutableMapOf<Rank,Int>().withDefault { 0 }
    private  var totalWinnings = 0L

    fun addResult(rank:Rank){
        rankCounts[rank] = rankCounts.getValue(rank) + 1
        totalWinnings += rank.prize
    }


}