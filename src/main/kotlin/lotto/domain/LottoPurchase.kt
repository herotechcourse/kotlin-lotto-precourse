package lotto.domain

class LottoPurchase private constructor(val tickets: List<LottoTicket>) {
    companion object {
        private const val LOTTO_PRICE = 1000

        fun from(amount: Int): LottoPurchase {
            require(amount % LOTTO_PRICE == 0) { "[ERROR] Amount must be divisible by $LOTTO_PRICE." }
            val ticketCount = amount / LOTTO_PRICE
            val tickets = List(ticketCount) { LottoTicket.generate() }
            return LottoPurchase(tickets)
        }
    }

    val ticketCount: Int = tickets.size

    override fun toString(): String = tickets.joinToString("\n")
} 