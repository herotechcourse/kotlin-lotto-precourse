package lotto
 
class LottoMachine()
{
    private var tickets: MutableList<Lotto> = mutableListOf()
    public val matchMap=mutableMapOf<MatchCondition, CountAndPrize>(
        MatchCondition.MATCH_3 to CountAndPrize(0,5_000),
        MatchCondition.MATCH_4 to CountAndPrize(0,50_000),
        MatchCondition.MATCH_5 to CountAndPrize(0,1_500_000),
        MatchCondition.MATCH_5_AND_BONUS to CountAndPrize(0,30_000_000),
        MatchCondition.MATCH_6 to CountAndPrize(0,2_000_000_000)
    )

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

            matchMap[matchCondition]?.count = matchMap.getOrDefault(matchCondition, CountAndPrize(0,0)).count + 1
        }
    }

    fun calcReturnRate(purchaseAmount:Int):Double
    { 
        var returnRate=0
        for ((_, countPrize) in matchMap) { 
            returnRate += countPrize.count * countPrize.prize 
        }
        return  ( purchaseAmount/returnRate.toDouble()) * 100.0
    }
}