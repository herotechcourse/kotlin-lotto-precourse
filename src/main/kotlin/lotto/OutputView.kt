package lotto

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
        println()
    }
}