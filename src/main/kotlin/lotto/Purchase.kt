package lotto

class Purchase(private val amount: Int) {
    val tickets: List<Ticket> = List(amount / TICKET_PRICE) { Ticket() }

    init {
        require(amount % TICKET_PRICE == 0) {
            "[ERROR] Only purchase amount divisible" +
                    " by $TICKET_PRICE is accepted."
        }
        require(amount in TICKET_PRICE..MAX_AMOUNT) {
            "[ERROR] Amount cannot be lower than $TICKET_PRICE or higher than $MAX_AMOUNT."
        }
    }

    fun calculateReturnRate(totalPrize: Int): Double {
        return (totalPrize / amount.toDouble() * 100) // converting one operand to Double to ensure a precise calculation
    }

    companion object {
        private const val TICKET_PRICE = 1000
        private const val MAX_AMOUNT = 15000
    }
}