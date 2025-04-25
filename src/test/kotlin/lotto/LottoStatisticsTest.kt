package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

    @Test
    fun `increase five matches prize's ticket count when match count is 5 and has bonus is false`() {
        val lottoStatistics = LottoStatistics.of()
        val matchCount = 5
        val hasBonus = false

        lottoStatistics.updateTicketCount(matchCount, hasBonus)

        assertEquals(1, lottoStatistics.statistics[2].ticketCount)
    }

    @Test
    fun `increase five matches with bonus prize's ticket count when match count is 5 and has bonus is true`() {
        val lottoStatistics = LottoStatistics.of()
        val matchCount = 5
        val hasBonus = true

        lottoStatistics.updateTicketCount(matchCount, hasBonus)

        assertEquals(1, lottoStatistics.statistics[3].ticketCount)
    }

    @Test
    fun `profit rate is total prize amount divided by purchase amount percentage`() {
        val lotto = Lotto(listOf(1, 3, 4, 5, 22, 11))
        val issuedTickets = FixedIssuedTicketsGenerator.of()
        val bonusNumber = 30
        val purchaseAmount = 8000
        val statistics = LottoStatistics.of()
        lotto.simulate(issuedTickets, bonusNumber, statistics)

        val profitRate = statistics.getProfitRate(purchaseAmount)

        val expectedProfitRate = 30_060_000.0 / 8000 * 100
        assertEquals(expectedProfitRate, profitRate)
    }
}
