package lotto.display

import lotto.Lotto

class TicketDisplay {
    fun displayTickets(numberOfTickets: Int, tickets: List<Lotto>) {
        // Display the number of tickets purchased
        println("You have purchased $numberOfTickets tickets.")

        // Display each ticket's numbers in the desired format
        tickets.forEach { ticket ->
            println(ticket.getNumbers().toString())
        }
    }
}