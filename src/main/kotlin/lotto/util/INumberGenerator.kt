package lotto.util

/**
 * Generates a set of six unique numbers for a Lotto ticket.
 */
interface INumberGenerator {
    fun generate(): List<Int>
}
