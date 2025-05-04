package views

import lotto.Lotto
import lotto.MatchCondition
import lotto.CountAndPrize

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        for(ticket in tickets) {
            println(ticket)
        }
    }

    fun printMatches(matchMap:MutableMap<MatchCondition, CountAndPrize>)
    {
        println()
        println("Winning Statistics")
        println("---")
        for ((condition, countAndPrize) in matchMap) {
            println("${condition.label} – ${countAndPrize.count} tickets")
        }       
    }

    fun printReturnRate(returnRate:Double)
    {
        println("Total return rate is ${String.format("%.1f", returnRate)}%.")
    }
}