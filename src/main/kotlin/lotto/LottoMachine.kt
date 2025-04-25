package lotto
 
class LottoMachine()
{
    private var tickets: MutableList<Lotto> = mutableListOf()

    fun calcTicketNumber(purchaseAmount:Int):Int
    {
        return purchaseAmount/1000
    }

    fun issueTickets(ticketsCount:Int):MutableList<Lotto>
    {
        var tickets = mutableListOf<Lotto>() 
        for(t in 1..ticketsCount) {
            val uniqueNumbers = Lotto.getUniqueNumbers() 
            var ticket = Lotto(uniqueNumbers)
            tickets.add(ticket)
        }
        this.tickets=tickets
        return tickets
    }

    fun checkMatches(winningNumbers:List<Int>, bonusNumber:Int)
    {
        val matchMap=mutableMapOf<MatchCondition, Int>(
            MatchCondition.MATCH_3 to 0,
            MatchCondition.MATCH_4 to 0,
            MatchCondition.MATCH_5 to 0,
            MatchCondition.MATCH_5_AND_BONUS to 0,
            MatchCondition.MATCH_6 to 0
        )
        for (ticket in tickets) {
            val matchCount = winningNumbers.count { it in ticket.getNumbers() }

            val matchCondition = listOf(
                MatchCondition.MATCH_3.takeIf { matchCount == 3 },
                MatchCondition.MATCH_4.takeIf { matchCount == 4 },
                MatchCondition.MATCH_5.takeIf { matchCount == 5 && bonusNumber !in ticket.getNumbers() },
                MatchCondition.MATCH_5_AND_BONUS.takeIf { matchCount == 5 && bonusNumber in ticket.getNumbers() },
                MatchCondition.MATCH_6.takeIf { matchCount == 6 }
            ).filterNotNull().firstOrNull()

            if(matchCondition==null) continue

            matchMap[matchCondition] = matchMap.getOrDefault(matchCondition, 0) + 1
    
            matchMap.forEach { (condition, count) ->
                println("${condition}: $count matches")
            }
        }
    }
}