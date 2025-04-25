package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\n You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            println(it)
        }
    }
    
}