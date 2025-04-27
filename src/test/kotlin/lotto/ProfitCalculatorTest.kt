package lotto

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProfitCalculatorTest {
    @Test
    fun `assert that when spend 8000 and wins SECOND prize, the rate is 375000`() {
        val winningResults = listOf(TicketResults(5, true, Prize.SECOND))
        val budget = 8000
        val profitCalculator = ProfitCalculator()
        val expected = 375000.0
        val rate = profitCalculator.calculate(budget, winningResults)
        assertEquals(expected, rate)
    }

    @Test
    fun `assert that when the prize is NO_PRIZE the rate is 0`() {
        val winningResults = listOf(TicketResults(0, false, Prize.NO_PRIZE))
        val budget = 1000
        val profitCalculator = ProfitCalculator()
        val expected = 0.0
        val rate = profitCalculator.calculate(budget, winningResults)
        assertEquals(expected, rate)
    }

    @Test
    fun `assert that spend 1000 and wins FIRST prize, the rate is 200000000,0`() {
        val winningResults = listOf(TicketResults(6, false, Prize.FIRST))
        val budget = 1000
        val profitCalculator = ProfitCalculator()
        val expected = 200000000.0
        val rate = profitCalculator.calculate(budget, winningResults)
        assertEquals(expected, rate)
    }

    @Test
    fun `assert that spend 3000 and wins THIRD and FIFTH prize, the rate is 200000000,0`() {
        val winningResults = listOf(TicketResults(5, false, Prize.THIRD), TicketResults(3, false, Prize.FIFTH))
        val budget = 3000
        val profitCalculator = ProfitCalculator()
        val expected = 50166.66666666667
        val rate = profitCalculator.calculate(budget, winningResults)
        assertEquals(expected, rate)
    }
}