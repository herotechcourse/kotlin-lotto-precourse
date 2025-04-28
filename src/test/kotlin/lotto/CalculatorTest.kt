package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.math.abs

class CalculatorTest {
    @Test
    fun `throws an exception in case purchase amount equals 0`() {
        assertThrows<IllegalArgumentException> {
            Calculator.rate(mapOf(PrizeRankCriteria.FIFTH to 2), 0)
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `throws an exception in case purchase amount equals -1`() {
        assertThrows<IllegalArgumentException> {
            Calculator.rate(mapOf(PrizeRankCriteria.FIFTH to 2), -1_000)
        } .also { e -> assertTrue(e.message!!.startsWith(ERROR_MESSAGE)) }
    }

    @Test
    fun `calculate profit rate,2 tickets is FIFTH prize rank, purchase amount is 2_000`() {
        val result = mapOf(PrizeRankCriteria.FIFTH to 2)
        assertTrue(isApproximatelyEqual(Calculator.rate(result, 2_000), 500.0))
    }

    @Test
    fun `calculate profit rate, FIFTH rank ticket, FORTH rank ticket, purchase amount is 100_000`() {
        val result = mapOf(PrizeRankCriteria.FIFTH to 1, PrizeRankCriteria.FOURTH to 1)
        assertTrue(isApproximatelyEqual(Calculator.rate(result, 100_000), 55.0))
    }

    private fun isApproximatelyEqual(a: Double, b: Double, epsilon: Double = 1e-6): Boolean {
        return abs(a - b) < epsilon
    }

    companion object {
        private const val ERROR_MESSAGE: String = "[ERROR]"
    }
}