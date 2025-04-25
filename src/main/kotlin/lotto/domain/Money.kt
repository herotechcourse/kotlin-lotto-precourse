package lotto.domain

class Money(private val amount: Int) {

    init {
        require(amount >= TICKET_PRICE) {
            "[ERROR] Invalid purchase amount. Must be at least ₩1,000."
        }
        require(amount % TICKET_PRICE == 0) {
            "[ERROR] Purchase amount must be a multiple of ₩1,000."
        }
    }

    fun countTickets(): Int = amount / TICKET_PRICE

    fun value(): Int = amount

    companion object {
        const val TICKET_PRICE = 1000
    }
}