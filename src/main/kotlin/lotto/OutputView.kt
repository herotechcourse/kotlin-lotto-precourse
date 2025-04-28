package lotto

object OutputView {

    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")

        tickets.forEach {ticket ->
            val sortedNumbers = ticket.getNumbers().sorted()
            println(sortedNumbers)
        }
    }
}
