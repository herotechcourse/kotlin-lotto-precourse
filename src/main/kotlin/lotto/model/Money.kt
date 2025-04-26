package lotto.model

class Money(private val amount: Int) {

    init {
        require(amount > 0) { "[ERROR] Amount must be greater than 0." }
        require(amount % 1000 == 0) { "[ERROR] Amount must be a multiple of 1000." }
    }

    fun getAmount(): Int {
        return amount
    }

    fun getTicketCount(): Int {
        return amount / 1000
    }

}
