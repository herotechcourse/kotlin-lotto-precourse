package lotto

class OutputHandler {
    fun printTickets(ticketCount: Int, tickets: List<Lotto>) {
        println("\nYou have purchased $ticketCount tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

}