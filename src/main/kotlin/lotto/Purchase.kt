package lotto

class Purchase(private val amount: Int) {

    init {
        require(amount > 0 && amount % 1000 == 0) {
            "[ERROR] Purchase amount must be in multiples of 1,000 KRW."
        }
    }

    fun ticketCount(): Int = amount / 1000

    fun totalAmount(): Int = amount
}
