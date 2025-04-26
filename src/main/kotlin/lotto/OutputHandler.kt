package lotto

class OutputHandler {
    fun printTicketNumber(count:Int){
        println("\nYou have purchased $count tickets.")
    }

    fun printTickets(tickets: List<Lotto>){
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }

    }
}