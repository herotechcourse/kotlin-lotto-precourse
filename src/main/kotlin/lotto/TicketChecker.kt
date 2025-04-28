package lotto

object TicketChecker {
    // map <rank, ticketCount>
    private val rankStatistics = mutableMapOf<Rank, Int>()
    init {
        resetStatistics()
    }
    fun resetStatistics() {
        rankStatistics.clear()
        Rank.entries.forEach { rankStatistics[it] = 0 }
    }

    fun addStatistics ( myLotto : Lotto, winningNumbers : Lotto, bonusNumber : Int) {
        val matchingNumbers = myLotto.countMatchingNumbers(winningNumbers)
        if( matchingNumbers == 3 ){
            rankStatistics[Rank.THREE] = rankStatistics[Rank.THREE]!! + 1
        } else if ( matchingNumbers == 4 ) {
            rankStatistics[Rank.FOUR] = rankStatistics[Rank.FOUR]!! + 1
        } else if ( matchingNumbers == 5 && myLotto.containsNumber(bonusNumber)) {
            rankStatistics[Rank.FIVE_BONUS] = rankStatistics[Rank.FIVE_BONUS]!! + 1
        } else if ( matchingNumbers == 5 ) {
            rankStatistics[Rank.FIVE] = rankStatistics[Rank.FIVE]!! + 1
        } else if ( matchingNumbers == 6 ) {
            rankStatistics[Rank.SIX] = rankStatistics[Rank.SIX]!! + 1
        }
    }

    fun getStatistics () : Map<Rank, Int>{
        return rankStatistics
    }

}