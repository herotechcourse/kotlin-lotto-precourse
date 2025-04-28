package lotto

object OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }
}
