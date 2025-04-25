package lotto

class OutputView {
    fun displayTickets(tickets: List<Ticket>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            print("[")
            print(ticket.sortedNumbers.joinToString(", "))
            println("]")
        }
    }
}