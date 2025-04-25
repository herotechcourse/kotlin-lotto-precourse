package views

import lotto.Lotto
import lotto.MatchCondition
import lotto.CountAndPrize

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for(ticket in tickets) {
            println(ticket)
        }
    }

    fun printMatches(matchMap:MutableMap<MatchCondition, CountAndPrize>)
    {
        
        for ((condition, countAndPrize) in matchMap) {
            println("${condition.label} - ${countAndPrize.count} tickets")
        }       
    }
}