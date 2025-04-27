package lotto

class PrizeCalculator(private val winningNumbers: List<Int>, private val bonusNumber:Int){
    fun calculateResults(tickets: List<Lotto>): Statistics{
        val statistics = Statistics()

        tickets.forEach { ticket ->
            val matchCount = ticket.countMatches(winningNumbers)
            val hasBonus = ticket.hasBonus(bonusNumber)
            val rank = Rank.determineRank(matchCount,hasBonus)
            statistics.addResult(rank)
        }
        return statistics
    }
}