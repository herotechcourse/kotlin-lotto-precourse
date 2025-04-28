package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalcReturnRateTest {

    @Test
    fun `calculates correct profit percentage`() {
        val totalPrize = 5000
        val purchaseAmount = 10000

        val profitRate = calcReturnRate(totalPrize, purchaseAmount)

        assertThat(profitRate).isEqualTo(50.0)
    }

    @Test
    fun `calculates 100 percent profit when totalPrize equals purchase amount`() {
        val totalPrize = 10000
        val purchaseAmount = 10000

        val profitRate = calcReturnRate(totalPrize, purchaseAmount)

        assertThat(profitRate).isEqualTo(100.0)
    }

    @Test
    fun `calculates 0 percent profit when totalPrize is zero`() {
        val totalPrize = 0
        val purchaseAmount = 10000

        val profitRate = calcReturnRate(totalPrize, purchaseAmount)

        assertThat(profitRate).isEqualTo(0.0)
    }
}
