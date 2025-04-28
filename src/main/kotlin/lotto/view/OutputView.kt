package lotto.view

class OutputView {
    fun purchasedTicket(count: Int) {
        println("")
        println("You have purchased $count tickets.")
    }

    fun ticketNumber(tickets: List<List<Int>>) {
        tickets.forEach {
            println(it)
        }
    }
}