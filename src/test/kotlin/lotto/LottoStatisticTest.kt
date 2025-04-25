package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoStatisticTest {

    @Test
    fun `is match when match count is equals prize value`() {
        val statistic = LottoStatistic(LottoPrize.FIVE_MATCHES)
        val matchCount = 5

        val isMatch = statistic.isMatch(matchCount, false)

        assertEquals(true, isMatch)
    }

    @Test
    fun `is not match when match count is not equals prize value`() {
        val statistic = LottoStatistic(LottoPrize.FIVE_MATCHES)
        val matchCount = 10

        val isMatch = statistic.isMatch(matchCount, false)

        assertEquals(false, isMatch)
    }

    @Test
    fun `update ticket count`() {
        val statistic = LottoStatistic(LottoPrize.FIVE_MATCHES)

        statistic.updateTicketCount()
        statistic.updateTicketCount()

        assertEquals(2, statistic.ticketCount)
    }

    @Test
    fun `each prize amount is prize amount multiplied by ticket count`() {
        val statistic = LottoStatistic(LottoPrize.FIVE_MATCHES)
        statistic.updateTicketCount()
        statistic.updateTicketCount()

        val prizeAmount = statistic.getPrizeAmount()

        val expectedPrizeAmount = 1_500_000 * 2
        assertEquals(expectedPrizeAmount, prizeAmount)
    }
}
