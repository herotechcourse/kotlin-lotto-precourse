package lotto.domain

class UserLottoTickets(private val tickets: List<Lotto>) {
    fun getTickets(): List<Lotto> = tickets
}