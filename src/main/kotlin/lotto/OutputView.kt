package lotto

object OutputView {
    fun printTicketCount(count: Int) {
        println("You have purchased $count tickets")
    }

    fun printTickets (tickets: List <Lotto> ) {
        tickets.forEach {println(it.getNumbers())}
    }
}