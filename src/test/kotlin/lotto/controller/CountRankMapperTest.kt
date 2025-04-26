package lotto.controller

import lotto.Rank
import lotto.WinningStatistics
import lotto.view.CountRankResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CountRankMapperTest {

    @Test
    fun `creates responses reflecting each Rank's count`() {
        // Arrange
        val rankCounts: Map<Rank, Int> = Rank.entries.associateWith { 1 }
        val winningStatistics = WinningStatistics(rankCounts)

        // Act
        val responses: List<CountRankResponse> = CountRankMapper.toResponses(winningStatistics)

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
        val responses = CountRankMapper.toResponses(winningStatistics)

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
        val responses = CountRankMapper.toResponses(winningStatistics)

        // Assert
        assertThat(responses).hasSize(Rank.entries.size - 1)
            .extracting("count")
            .containsOnly(0, 2)
    }

}
