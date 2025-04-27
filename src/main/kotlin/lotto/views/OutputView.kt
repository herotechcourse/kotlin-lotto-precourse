package lotto.views

import lotto.LotteryResults
import lotto.Lotto

class OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>, ticketCount: Int){
        println("You have purchased $ticketCount tickets.")
        tickets.forEach { ticket ->
            println(ticket.getTicketNumbers())
        }
    }
    fun printResults(tickets: List<Lotto>, winningNumbers: List<Int>){
        val matchCount = tickets.map{
                ticket -> ticket.getMatchingNumbers(winningNumbers)
        }

        val results = LotteryResults()
        matchCount.forEach { match ->
            if (match > 3) {
                val rank = results.getRank(match)
                val prize = results.formatPrize(rank)
                println("$match Matches ($prize KRW) - ")
            }
        }
    }
}