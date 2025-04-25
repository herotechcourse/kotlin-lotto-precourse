package lotto.domain

class LottoTickets(private val tickets: List<Lotto>) {

    fun size(): Int = tickets.size

    fun getAll(): List<Lotto> = tickets.toList()

    override fun toString(): String {
        return tickets.joinToString("\n") { it.toString() }
    }
}