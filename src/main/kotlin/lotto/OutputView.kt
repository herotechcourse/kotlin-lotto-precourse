package lotto

interface LottoOutputView {
    fun showTicketCount(count: Int)
    fun showError(message: String)
    fun printTickets(tickets: List<Lotto>)
}


class OutputView : LottoOutputView {
    override fun showError(message: String) {
        println("[ERROR] $message")
    }

    override fun showTicketCount(count: Int) {
        println("You have purchased $count tickets.")
    }

    override fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { println(it) }
    }
}