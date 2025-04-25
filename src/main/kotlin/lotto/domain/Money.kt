package lotto.domain

import lotto.Lotto

class Money(private val money: Int) {

    init {
        require(money > 0) { "[ERROR] Amount must be greater than 0" }
        require(money % Lotto.TICKET_PRICE == 0) {
            "[ERROR] Amount must be divisible by ${Lotto.TICKET_PRICE}"
        }
    }

    fun countTickets(): Int {
        return money / Lotto.TICKET_PRICE
    }
}