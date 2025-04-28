package lotto

class LottoTicket(private val tickets: List<Lotto>) {

    fun getTickets(): List<Lotto> = tickets.toList()
}
