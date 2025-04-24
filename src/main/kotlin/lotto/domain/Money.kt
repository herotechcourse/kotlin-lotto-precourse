package lotto.domain

class Money(private val money: Int) {

    init {
        require(money > 0) { "[ERROR] Amount must be greater than 0" }
        require(money % TICKET_PRICE == 0) { "[ERROR] Amount must be divisible by $TICKET_PRICE" }
    }

    fun countTickets(): Int {
        return money / TICKET_PRICE
    }

    companion object {
        private const val TICKET_PRICE = 1000
    }
}