package lotto.service

import lotto.core.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    private val calculator = ProfitCalculator()

    @Test
    fun `calculate returns zero when no winnings`() {
        val stats = Rank.values().associateWith { 0 }
        val purchaseAmount = 10_000

        val rate = calculator.calculate(stats, purchaseAmount)

        assertEquals(0.0, rate, "With zero prizes, return rate should be 0.0%")
    }

    @Test
    fun `calculate returns correct rate for uniform rank`() {
        val stats = mapOf(Rank.FOUR to 2)
        val purchaseAmount = 2 * 1_000  // spent 2,000 KRW
        val rate = calculator.calculate(stats, purchaseAmount)

        assertEquals(5.0, rate, "Expected a 5.0% return rate")
    }

    @Test
    fun `calculate handles mixed prize ranks correctly`() {
        val stats = mapOf(
            Rank.THREE to 1,
            Rank.FIVE_PLUS to 1
        )
        val purchaseAmount = 2 * 1_000
        val expected = ((5_000L + 30_000_000L) / 1_000).toDouble() / purchaseAmount * 100

        val rate = calculator.calculate(stats, purchaseAmount)

        assertEquals(expected, rate, "Mixed prizes should calculate to $expected%")
    }
}