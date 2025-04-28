package lotto

class Cashier (private val ticketPrice: Int) {
    
    init { require(ticketPrice != 0) { "Ticket price must not be zero." } }
    
    /**
     * Calculates the number of tickets that can be purchased with the given amount.
     *
     * @param amount The total amount of money available for purchasing tickets.
     * @return The number of tickets that can be purchased.
     */
    fun calculateNumberOfTickets(amount: Int): Int {
        return amount / ticketPrice
    }
}
