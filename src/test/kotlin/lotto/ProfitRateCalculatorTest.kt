package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProfitRateCalculatorTest {

    @BeforeEach
    fun setup() {
        TicketChecker.resetStatistics()
    }

    @Test
    fun `returns 0 profit rate when no prizes won`() {
        // given
        val purchaseAmount = 8000

        // when
        val profitRate = ProfitRateCalculator.calculateProfitRate(purchaseAmount)

        // then
        assertThat(profitRate).isEqualTo(0.0)
    }

    @Test
    fun `calculates profit rate correctly for 3rd rank prize`() {
        // given
        createThirdRankMatch()
        val purchaseAmount = 8000

        // when
        val profitRate = ProfitRateCalculator.calculateProfitRate(purchaseAmount)

        // then
        assertThat(profitRate).isEqualTo(5000.0 / 8000.0 * 100) // 62.5%
    }

    @Test
    fun `calculates profit rate correctly for multiple prizes`() {
        // given
        createThirdRankMatch()
        createThirdRankMatch()
        createFourthRankMatch()
        val purchaseAmount = 10000

        // when
        val profitRate = ProfitRateCalculator.calculateProfitRate(purchaseAmount)

        // then
        assertThat(profitRate).isEqualTo(60000.0 / 10000.0 * 100) // 600.0%
    }

    @Test
    fun `returns 0 profit rate when purchase amount is 0`() {
        // given
        createThirdRankMatch()
        val purchaseAmount = 0

        // when
        val profitRate = ProfitRateCalculator.calculateProfitRate(purchaseAmount)

        // then
        assertThat(profitRate).isEqualTo(0.0)
    }

    private fun createThirdRankMatch() {
        val myLotto = Lotto(listOf(1, 2, 3, 40, 41, 42))
        val winningLotto = Lotto(listOf(1, 2, 3, 30, 31, 32))
        TicketChecker.addStatistics(myLotto, winningLotto, 10)
    }

    private fun createFourthRankMatch() {
        val myLotto = Lotto(listOf(1, 2, 3, 4, 41, 42))
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 31, 32))
        TicketChecker.addStatistics(myLotto, winningLotto, 10)
    }
}