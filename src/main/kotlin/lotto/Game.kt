package lotto



class Game(val player: Player, val winningTicket: Lotto, val bonusNumber: Int) {

    enum class Prize(val matchCount: Int, val bonus: Boolean, val Amount: Int){
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000)
    }

    val finalMatches: List<Pair<Int, Boolean>> = getMatches(player.tickets)
    val statistics: List<Pair<Prize, Int>> = getStatistics(finalMatches)

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


}