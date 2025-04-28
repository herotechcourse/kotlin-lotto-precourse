package lotto

class Lottos(private val tickets: List<Lotto>) {
    fun getTickets(): List<Lotto> = tickets.toList()
}