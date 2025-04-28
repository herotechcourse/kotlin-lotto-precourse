package lotto.archive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class RoundProfitRateTest {
    @Test
    fun `givenNumberEndingWithLessThanFive_whenRounded_thenTruncatesToOneDecimalPlace` () {
        val input = 100.149
        val expected = 100.1
        val result = roundProfitRate(input)
        assertEquals(expected, result)
    }

    @Test
    fun `givenNumberEndingWithFive_whenRounded_thenRoundsUpToOneDecimalPlace`() {
        val input = 100.151
        val expected = 100.2
        val result = roundProfitRate(input)
        assertEquals(expected, result)
    }

    @Test
    fun `givenNumberEndingWithGreaterThanFive_whenRounded_thenRoundsUpToOneDecimalPlace`() {
        val input = 100.171
        val expected = 100.2
        val result = roundProfitRate(input)
        assertEquals(expected, result)
    }
}