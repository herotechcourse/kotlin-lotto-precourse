package lotto.domain

class Money(val amount: Int) {

    init {
        require(amount >= 0) { "[ERROR] Amount cannot be negative." }
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }
    }

    fun getNumberOfTickets(): Int {
        return amount / 1000
    }
 }
