package lotto.domain

class PrizeResult {
    private val rankCount = mutableMapOf<Rank, Int>()
    var totalPrize:Int = 0
        private set

    fun add (rank: Rank){
        rankCount[rank] = rankCount.getOrDefault(rank, 0) + 1
        totalPrize += rank.prize
    }

    fun getRankCount (rank: Rank): Int{
        return rankCount.getOrDefault(rank, 0)
    }
}