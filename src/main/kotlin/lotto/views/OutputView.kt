package lotto.views
import lotto.Lotto

class OutputView {
    // prints the number of purchased tickets and their numbers
    fun printPurchasedTickets(tickets: List<Lotto>, ticketCount: Int){
        println("You have purchased $ticketCount tickets.")
        tickets.forEach { ticket ->
            println(ticket.getTicketNumbers())
        }
    }

    // prints prize summary for winning lottery tickets
    fun printPrizeSummary(prizeSummary: List<String>) {
        prizeSummary.forEach { prize ->
            println(prize)
        }
    }

    // prints the return rate of the lottery
    fun printReturnRate(returnRate: String){
        println("Total return rate is $returnRate%.")
    }
}
