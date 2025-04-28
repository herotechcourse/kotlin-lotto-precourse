package lotto.controller

import lotto.Lotto
import lotto.LottoTickets
import lotto.Rank
import lotto.WinningStatistics
import lotto.view.CountRankResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ResponseMapperTest {

    @Nested
    inner class LottoTickets {

        private val numbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(11, 12, 13, 14, 15, 16)
        )

        @Test
        fun `converts LottoTickets to List of numbers correctly`() {
            // Arrange
            val lottoTickets = LottoTickets(listOf(Lotto(numbers[0]), Lotto(numbers[1])))

            // Act
            val responses: List<List<Int>> = ResponseMapper.toResponses(lottoTickets)

            // Assert
            assertThat(responses).hasSize(2)
                .containsExactly(numbers[0], numbers[1])
        }

        @Test
        fun `converts single LottoTicket to List of numbers correctly`() {
            // Arrange
            val lottoTickets = LottoTickets(listOf(Lotto(numbers[0])))

            // Act
            val responses = ResponseMapper.toResponses(lottoTickets)

            // Assert
            assertThat(responses).hasSize(1)
                .containsExactly(numbers[0])
        }

    }

    @Nested
    inner class WinningStatistics {

        @Test
        fun `creates responses reflecting each Rank's count`() {
            // Arrange
            val rankCounts: Map<Rank, Int> = Rank.entries.associateWith { 1 }
            val winningStatistics = WinningStatistics(rankCounts)

            // Act
            val responses: List<CountRankResponse> = ResponseMapper.toResponses(winningStatistics)

            // Assert
            assertThat(responses).filteredOn { it.matchCount > 0 }
                .hasSize(Rank.entries.size - 1)
                .extracting("count")
                .containsOnly(1)
        }

        @Test
        fun `ignores NONE Rank regardless of its count`() {
            // Arrange
            val rankCounts: Map<Rank, Int> = mapOf(Rank.NONE to 5)
            val winningStatistics = WinningStatistics(rankCounts)

            // Act
            val responses = ResponseMapper.toResponses(winningStatistics)

            // Assert
            assertThat(responses).hasSize(Rank.entries.size - 1)
                .extracting("count")
                .containsOnly(0)
        }

        @Test
        fun `creates responses when only partial Ranks are provided`() {
            // Arrange
            val rankCounts = mapOf(Rank.FOURTH to 2)
            val winningStatistics = WinningStatistics(rankCounts)

            // Act
            val responses = ResponseMapper.toResponses(winningStatistics)

            // Assert
            assertThat(responses).hasSize(Rank.entries.size - 1)
                .extracting("count")
                .containsOnly(0, 2)
        }

    }

}
