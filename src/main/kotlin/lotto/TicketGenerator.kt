package lotto

import camp.nextstep.edu.missionutils.Randoms

class TicketGenerator (
    /**
     * Generates a list of lottery tickets.
     *
     * @param minNumber The minimum number in the range.
     * @param maxNumber The maximum number in the range.
     * @param numbersCount The number of unique numbers in each ticket.
     */
    private val minNumber: Int,
    private val maxNumber: Int,
    private val numbersCount: Int,
) {
    init { 
        require(numbersCount > 0) { "Numbers count must be greater than zero." }
        require(minNumber > 0) { "Minimum number must be greater than zero." }
        require(maxNumber > 0) { "Maximum number must be greater than zero." }
        require(minNumber < maxNumber) { "Minimum number must be less than maximum number." }
    }

    /**
     * Generates a list of lottery tickets.
     *
     * @param amount The number of tickets to generate.
     * @return A list of lists, where each inner list represents a ticket with 6 unique numbers.
     */
    fun generate(amount: Int): List<List<Int>> {
        return (1..amount).map { 
            Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, numbersCount).sorted() 
        }
    }
}
