package lotto.domain

class LottoTicketCalculator() {
    fun calculateTicketCount(amount: Int): Int {
        require(amount % LOTTO_UNIT_PRICE == ZERO ) { INVALID_LOTTO_AMOUNT}
        return amount / LOTTO_UNIT_PRICE
    }

    companion object {
        const val LOTTO_UNIT_PRICE = 1000
        const val INVALID_LOTTO_AMOUNT = "[ERROR] lotto amount must be divisible by 1,000"
        const val ZERO = 0
    }
}