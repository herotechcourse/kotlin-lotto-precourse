package lotto

class Purchase(val amount: Int) {
    val tickets: List<Ticket> = List(amount / TICKET_PRICE) { Ticket() }

    init {
        require(amount % TICKET_PRICE == 0) {
            "[ERROR] Only purchase amount divisible" +
                    " by $TICKET_PRICE is accepted."
        }
    }

    companion object {
        private const val TICKET_PRICE = 1000
    }
    // Property declarations
    // Initializer blocks
    // Secondary constructors
    // Method declarations
    // Companion object
}