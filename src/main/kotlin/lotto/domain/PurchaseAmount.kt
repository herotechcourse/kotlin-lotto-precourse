package lotto.domain

class PurchaseAmount(
    private val amount: Int
) {
    init {
        require(amount >= 1_000 && amount % 1_000 == 0) {
            "[ERROR] Purchase amount must be at least 1,000 KRW and divisible by 1,000."
        }
    }

    fun ticketCount(): Int =
        amount / 1_000
}
