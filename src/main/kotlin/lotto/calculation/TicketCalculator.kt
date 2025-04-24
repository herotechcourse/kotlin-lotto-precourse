package lotto.calculation

class TicketCalculator {

    // Ticket price in KRW
    private val ticketPrice = 1000

    // Calculate number of tickets from the purchase amount
    fun calculateNumberOfTickets(amount: Int): Int {
        return amount / ticketPrice
    }
}