package lotto.domain

class LottoTicket (private val amount: Long) {
    init {
//        require (amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1,000."}
    }
    fun ticketCount() : Long = amount / 1000
}
