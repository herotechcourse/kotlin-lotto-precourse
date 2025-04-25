package lotto.io

import lotto.Lotto

object OutputHandler {
    fun showTickets(tickets: MutableList<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            ticket.showNumbers()
        }
    }

    fun showStatistics(ticketMatchesMap: MutableMap<String, Int>) {
        println("Winning Statistics")
        println("---")
        println(
            "3 Matches (5,000 KRW) – ${ticketMatchesMap["match3"]} tickets\n" + "4 Matches (50,000 KRW) – ${ticketMatchesMap["match4"]} tickets\n" + "5 Matches (1,500,000 KRW) – ${ticketMatchesMap["match5"]} tickets\n" + "5 Matches + Bonus Ball (30,000,000 KRW) – 0 tickets\n" + "6 Matches (2,000,000,000 KRW) – ${ticketMatchesMap["match6"]} tickets"
        )
    }

    fun showTotalRate(number: Double) {
        println("Total return rate is ${number}%. ")
    }
}