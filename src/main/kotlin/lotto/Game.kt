package lotto

class Game(val player: Player, val winningTicket: Lotto, val bonusNumber: Int) {
    init {
        require(bonusNumber >= 1 && bonusNumber <= 45) { "Bonus number must be between 1 and 45" }
    }

    enum class Prize(val matchCount: Int, val bonus: Boolean, val amount: Int){
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000)
    }

    val finalMatches: List<Pair<Int, Boolean>> by lazy {
        getMatches(player.tickets)
    }

    val statistics: List<Pair<Prize, Int>> by lazy {
        getStatistics(finalMatches)
    }
    val finalPrizeAmount: Long by lazy {
        getFinalPrizeAmount(statistics)
    }

    val profitRate: Double by lazy {
        getProfitRate(player.getAmount(), finalPrizeAmount)
    }

    fun getMatches(tickets: List<Lotto>): List<Pair<Int, Boolean>> {
        val finalMatches = tickets.map { ticket ->
            val matches = winningTicket.matches(ticket)
            val bonusMatched = ticket.contains(bonusNumber)
            Pair(matches, bonusMatched)
        }
        return finalMatches
    }

    fun getStatistics(finalMatches: List<Pair<Int, Boolean>>): List<Pair<Prize, Int>> {
        val statistics = Prize.entries.map { prize ->
            val count = finalMatches.count { (matchCount, bonusMatched) ->
                matchCount == prize.matchCount &&
                        ((prize.bonus && bonusMatched) ||
                                (!prize.bonus && !finalMatches.any {
                                    it.first == matchCount && it.second }))
            }
            Pair(prize, count)
        }
        return statistics
    }

    fun getFinalPrizeAmount(statistics: List<Pair<Prize, Int>>): Long {
        var amountEarned:Long = 0
        statistics.map{(prize, count) ->
            amountEarned += (prize.amount * count)
        }
        return amountEarned
    }

    fun getProfitRate(amount: Int, finalPrizeAmount: Long ): Double {
        return (finalPrizeAmount.toDouble() / amount) * 100
    }
}