package lotto

class Output {

    fun displayTickets(tickets: MutableList<MutableList<Int>>) {
        tickets.forEach { ticket ->
            println(ticket)

        }
    }
}