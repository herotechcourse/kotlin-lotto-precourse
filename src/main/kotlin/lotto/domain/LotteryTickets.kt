package lotto.domain

class LotteryTickets(private val lottos: List<LotteryTicket>) {
    val size: Int
        get() = lottos.size

    fun toList(): List<LotteryTicket> {
        return lottos
    }
}
