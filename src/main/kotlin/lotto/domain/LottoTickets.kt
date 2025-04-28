package lotto.domain


class LottoTickets (private val tickets: List<LottoTicket>) {
    fun getTickets(): List<LottoTicket> {
        return tickets.toList()
    }

    fun getSize(): Int {
        return tickets.size
    }

    fun getNumbersList(): List<List<Int>> {
        return tickets.map { it.getNumbers() }
    }
}