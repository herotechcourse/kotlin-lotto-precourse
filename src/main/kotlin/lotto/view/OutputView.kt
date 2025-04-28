package lotto

class OutputView {
    fun printTickets(tickets: List<List<Int>>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }

    fun printError(message: String?) {
        println(message)
    }
}
