package lotto

class Lottos(private val tickets: MutableList<Lotto>, private val ticketCount: Int) {
    init {
        repeat(ticketCount) {
            tickets.add(Lotto())
        }
    }

    fun getTickets(): List<Lotto> {
        return tickets
    }
}