package lotto.view
import lotto.Lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println(getPurchaseMessage(tickets.size))
        tickets.forEach { println(it) }
    }

    private fun getPurchaseMessage(count: Int) = "You have purchased $count tickets"
}