package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoGeneratorTest {
    @Test
    fun `throws an exception when lotto count is less than 1`() {
        assertThrows<IllegalArgumentException> {
            LottoGenerator.run(0)
        }
    }

    @Test
    fun `generates unique lotto numbers for each ticket`() {
        val tickets = LottoGenerator.run(5)
        val uniqueNumbers = mutableSetOf<Int>()
        for (ticket in tickets) {
            val numbers = ticket.getNumbers()
            assert(numbers.size == Configuration.LOTTO_NUMBER_COUNT) { "Each lotto ticket must contain exactly ${Configuration.LOTTO_NUMBER_COUNT} numbers." }
            assert(numbers.distinct().size == numbers.size) { "Lotto numbers must be unique." }
            assert(numbers.all { it in Configuration.MIN_NUMBER..Configuration.MAX_NUMBER }) { "Lotto numbers must be between ${Configuration.MIN_NUMBER} and ${Configuration.MAX_NUMBER}." }
            uniqueNumbers.addAll(numbers)
        }
    }
}