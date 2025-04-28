package lotto

import lotto.Application.Companion.Prize

class Cashier(private val ticketPrice: Int) {
    
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

    /**
     * Calculates the total return rate based on the total prize and the number of tickets purchased.
     *
     * @param totalPrize The total prize amount won.
     * @param numberOfTickets The number of tickets purchased.
     * @return The total return rate as a percentage.
     */
    fun calculateTotalReturnRate(results: Map<Prize, Int>, amount: Int): Double {
        val totalPrize = results.entries.sumOf { (prize, count) -> prize.amount * count }
        return (totalPrize.toDouble() / amount) * 100
    }
}
