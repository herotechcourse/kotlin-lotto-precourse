package lotto.domain

class Money(private val amount: Int) {

    init {
        require(amount >= UNIT) {
            "[ERROR] Purchase amount must be at least ₩$UNIT."
        }
        require(amount % UNIT == 0) {
            "[ERROR] Purchase amount must be divisible by ₩$UNIT."
        }
    }

    fun getTicketCount(): Int = amount / UNIT

    fun toInt(): Int = amount

    companion object {
        private const val UNIT = 1_000
    }
}