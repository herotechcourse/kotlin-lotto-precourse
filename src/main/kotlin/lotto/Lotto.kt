package lotto

/**
 * Represents a single Lotto ticket containing 6 unique numbers.
 *
 * @property numbers the list of numbers on the ticket
 * @throws IllegalArgumentException if numbers.size != 6 or numbers are not unique
 */
class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "[ERROR] Numbers must be unique." }
    }

    /**
     * Counts how many numbers in this ticket match the given winning numbers.
     *
     * @param winningNumbers the list of winning numbers to compare
     * @return the number of matching numbers
     */
    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    /**
     * Checks if the given number is contained in this ticket.
     *
     * @param number the number to check
     * @return true if the number exists in this ticket, false otherwise
     */
    fun contains(number: Int): Boolean {
        return number in numbers
    }

    /**
     * Displays the ticket numbers formatted as a list.
     */
    fun displayTicket() {
        println(numbers)
    }
}
