package lotto.archive

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CalcProfitRateTest {
    @Test
    fun `givenZeroWinningAmount_whenCalculateProfitRate_thenReturns0Percent`() {
        val totalWinningAmount = 0
        val totalLottoPurchaseAmount = 10000
        val expected = 0.0
        val result = calcProfitRate(totalWinningAmount, totalLottoPurchaseAmount)
        assertEquals(expected, result)
    }

    @Test
    fun `givenTotalWinningAmountAndTotalLottoPurchaseAmount_whenCalcProfitRate_thenReturns50Percent`() {
        val totalWinningAmount = 5000
        val totalLottoPurchaseAmount = 10000
        val expected = 50.0
        val result = calcProfitRate(totalWinningAmount, totalLottoPurchaseAmount)
        assertEquals(expected, result)
    }

    @Test
    fun `givenWinningAmountEqualToPurchaseAmount_whenCalcProfitRate_thenReturns100Percent`() {
        val totalWinningAmount = 10000
        val totalLottoPurchaseAmount = 10000
        val expected = 100.0
        val result = calcProfitRate(totalWinningAmount, totalLottoPurchaseAmount)
        assertEquals(expected, result)
    }

    @Test
    fun `givenWinningAmountGreaterThanPurchaseAmount_whenCalcProfitRate_thenReturns200Percent`() {
        val totalWinningAmount = 20000
        val totalLottoPurchaseAmount = 10000
        val expected = 200.0
        val result = calcProfitRate(totalWinningAmount, totalLottoPurchaseAmount)
        assertEquals(expected, result)
    }
}