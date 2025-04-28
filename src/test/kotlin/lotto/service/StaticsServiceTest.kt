import lotto.domain.LottoResult
import lotto.domain.PrizeRank
import lotto.Lotto
import lotto.service.StatisticsService
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class StatisticsServiceTest {

    @Nested
    @DisplayName("calculateReturnRate() Tests")
    inner class CalculateReturnRateTest {

        @Test
        @DisplayName("Should return 0.0% if no tickets are won")
        fun returnZeroWhenNoWinningTickets() {
            val results = listOf(
                LottoResult(Lotto(listOf(1,2,3,4,5,6)), PrizeRank.NONE, emptyList(), false),
                LottoResult(Lotto(listOf(7,8,9,10,11,12)), PrizeRank.NONE, emptyList(), false)
            )

            val returnRate = StatisticsService.calculateReturnRate(results, totalSpend = 2000)
            assertThat(returnRate).isEqualTo(0.0)
        }

        @Test
        @DisplayName("Should correctly calculate the return rate with winnings")
        fun calculateCorrectReturnRate() {
            val results = listOf(
                LottoResult(Lotto(listOf(1,2,3,4,5,6)), PrizeRank.FIFTH, listOf(1,2,3), false),  // 5,000 KRW
                LottoResult(Lotto(listOf(7,8,9,10,11,12)), PrizeRank.FOURTH, listOf(7,8,9,10), false)  // 50,000 KRW
            )

            val returnRate = StatisticsService.calculateReturnRate(results, totalSpend = 2000)
            val expectedRate = ((5_000 + 50_000) / 2000.0) * 100
            assertThat(returnRate).isEqualTo(expectedRate)
        }

        @Test
        @DisplayName("Should return 0.0% when total spend is 0 to avoid division by zero")
        fun returnZeroWhenSpendIsZero() {
            val results = listOf(
                LottoResult(Lotto(listOf(1,2,3,4,5,6)), PrizeRank.FIRST, listOf(1,2,3,4,5,6), false)
            )

            val returnRate = StatisticsService.calculateReturnRate(results, totalSpend = 0)
            assertThat(returnRate).isEqualTo(0.0)
        }
    }
}
