package lotto

class Purchase(val amount: Int) {
    val tickets: List<Ticket> = List(amount / TICKET_PRICE) { Ticket() }

    companion object {
        private const val TICKET_PRICE = 1000
    }
    // Property declarations
    // Initializer blocks
    // Secondary constructors
    // Method declarations
    // Companion object
}