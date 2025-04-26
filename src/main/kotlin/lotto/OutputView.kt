package lotto

class OutputView {
    fun printTickets(lottoTickets: List<Lotto>) {
        println("\nYou have purchased ${lottoTickets.size} tickets.")
        lottoTickets.forEach { println(it.getNumbers()) }
    }
}