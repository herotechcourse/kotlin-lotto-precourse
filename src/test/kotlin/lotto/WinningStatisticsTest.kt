package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class WinningStatisticsTest {

    private val rankCounts: Map<Rank, Int> = mapOf(
        Rank.FIRST to 1,
        Rank.SECOND to 1,
        Rank.THIRD to 1,
        Rank.FOURTH to 1,
        Rank.FIFTH to 1,
        Rank.NONE to 1,
    )

    @Test
    fun `creates WinningStatistics when rankCounts are valid`() {
        // Act
        // Assert
        assertThatCode { WinningStatistics(rankCounts) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throws exception when rankCounts is empty`() {
        // Arrange
        val rankCounts: Map<Rank, Int> = emptyMap()

        // Act
        // Assert
        assertThatThrownBy { WinningStatistics(rankCounts) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("rankCounts must not be empty")
    }

    @Nested
    inner class GetCountsTest {

        @ParameterizedTest
        @EnumSource
        fun `getCount returns correct count for given Rank`(rank: Rank) {
            // Arrange
            val sut = WinningStatistics(rankCounts)

            // Act
            val result: Int = sut.getCount(rank)

            // Assert
            assertThat(result).isEqualTo(1)
        }

        @Test
        fun `getCount returns 0 for missing Rank`() {
            // Arrange
            val sut = WinningStatistics(mapOf(Rank.FIRST to 1, Rank.SECOND to 2))

            // Act
            val missingRankCount: Int = sut.getCount(Rank.FOURTH)

            // Assert
            assertThat(missingRankCount).isEqualTo(0)
        }
    }

    @Nested
    inner class ProfitRateTest {

        @Test
        fun `profitRate returns 0 when no ticket wins`() {
            // Arrange
            val sut = WinningStatistics(mapOf(Rank.NONE to 2))

            // Act
            val rate: Double = sut.profitRate()

            // Assert
            assertThat(rate).isCloseTo(0.0, within(0.00001))
        }

        @Test
        fun `profitRate returns partial rate when some tickets win`() {
            // Arrange
            val sut = WinningStatistics(rankCounts)

            // Act
            val rate: Double = sut.profitRate()

            // Assert
            assertThat(rate).isCloseTo(33859250.0, within(0.00001))
        }

        @Test
        fun `profitRate returns correct rate when all tickets win`() {
            // Arrange
            val sut = WinningStatistics(mapOf(Rank.FIRST to 1, Rank.FIFTH to 3))

            // Act
            val rate = sut.profitRate()

            // Assert
            assertThat(rate).isCloseTo(50000375.0, within(0.00001))
        }
    }

}
