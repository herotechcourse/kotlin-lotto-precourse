package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.within
import org.junit.jupiter.api.assertThrows

class ProfitCalculatorTest {

    @Test
    fun `calculates profit rate correctly and rounds to one decimal`() {
        val profit = ProfitCalculator.calculate(totalPrize = 12500, purchaseAmount = 8000)
        assertThat(profit).isCloseTo(156.2, within(0.1))
    }

    @Test
    fun `returns 100 percent when profit equals purchase amount`() {
        val profit = ProfitCalculator.calculate(totalPrize = 10000, purchaseAmount = 10000)
        assertThat(profit).isCloseTo(100.0, within(0.1))
    }

    @Test
    fun `returns 0 percent when no winnings`() {
        val profit = ProfitCalculator.calculate(totalPrize = 0, purchaseAmount = 5000)
        assertThat(profit).isCloseTo(0.0, within(0.1))
    }

    @Test
    fun `throws exception when purchase amount is zero`() {
        assertThrows<IllegalArgumentException> {
            ProfitCalculator.calculate(totalPrize = 10000, purchaseAmount = 0)
        }
    }
}