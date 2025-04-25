package views

import lotto.MatchCondition
import lotto.Lotto

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for(ticket in tickets) {
            println(ticket)
        }
    }

    fun printMatches(matchMap:MutableMap<MatchCondition, Int>)
    {
        
        for ((condition, count) in matchMap) {
            println("${condition.label} - $count tickets")
        }       
    }
}