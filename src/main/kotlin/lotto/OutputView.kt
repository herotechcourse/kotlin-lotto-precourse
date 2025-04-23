package lotto

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { number ->
            number.displayTicket()
        }
        println("\n")
    }
}