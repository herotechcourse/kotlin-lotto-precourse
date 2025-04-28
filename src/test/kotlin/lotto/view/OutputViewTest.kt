import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.assertj.core.api.Assertions.assertThat
import camp.nextstep.edu.missionutils.test.NsTest
import lotto.Lotto
import lotto.domain.LottoResult
import lotto.view.OutputView
import lotto.domain.PrizeRank

class OutputViewTest : NsTest() {
    override fun runMain() {}

    @Nested
    @DisplayName("printTicket Test")
    inner class PrintTicketTest {

        @Test
        @DisplayName("Should print the correct purchase message and tickets")
        fun testPrintTickets() {
            val tickets = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12))
            )

            OutputView.printTickets(tickets)

            assertThat(output()).contains("You have purchased 2 tickets")
            assertThat(output()).contains("[1, 2, 3, 4, 5, 6]")
            assertThat(output()).contains("[7, 8, 9, 10, 11, 12]")
        }
    }

    @Nested
    @DisplayName("printWinningStatistics Test")
    inner class PrintWinningStatisticsTest {

        @Test
        @DisplayName("Should print winning statistics correctly")
        fun testPrintWinningStatistics() {
            val results = listOf(
                LottoResult(Lotto(listOf(1, 2, 3, 4, 5, 6)), PrizeRank.FIRST, listOf(1, 2, 3, 4, 5, 6), false),
                LottoResult(Lotto(listOf(1, 2, 3, 4, 5, 7)), PrizeRank.SECOND, listOf(1, 2, 3, 4, 5), true),
                LottoResult(Lotto(listOf(1, 2, 3, 4, 5, 8)), PrizeRank.THIRD, listOf(1, 2, 3, 4, 5), false)
            )

            OutputView.printWinningStatistics(results)

            assertThat(output()).contains("Winning Statistics")
            assertThat(output()).contains("---")
            assertThat(output()).contains("6 Matches (2,000,000,000 KRW) – 1 tickets")
            assertThat(output()).contains("5 Matches + Bonus Ball (30,000,000 KRW) – 1 tickets")
            assertThat(output()).contains("5 Matches (1,500,000 KRW) – 1 tickets")
        }
    }

    @Nested
    @DisplayName("printReturnRate Test")
    inner class PrintReturnRateTest {

        @Test
        @DisplayName("Should print return rate correctly")
        fun testPrintReturnRate() {
            OutputView.printReturnRate(62.5)

            assertThat(output()).contains("Total return rate is 62.5%.")
        }
    }
}