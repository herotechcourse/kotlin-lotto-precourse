package lotto

import org.assertj.core.api.Assertions.*
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class WinningStatisticsTest {

    @Test
    fun `creates WinningStatistics when rankCounts are valid`() {
        // Arrange
        val rankCounts = mapOf(Rank.FIFTH to 1, Rank.NONE to 1)

        // Act
        // Assert
        assertThatCode { WinningStatistics(rankCounts) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throws exception when rankCounts is empty`() {
        // Act
        // Assert
        assertThatThrownBy { WinningStatistics(emptyMap()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("rankCounts must not be empty")
    }

    @Nested
    inner class GetCountsTest {

        private val sut = WinningStatistics(mapOf(Rank.FIRST to 1, Rank.SECOND to 2))

        @Test
        fun `getCount returns correct count for given Rank`() {
            // Act
            val firstCount = sut.getCount(Rank.FIRST)
            val secondCount = sut.getCount(Rank.SECOND)

            // Assert
            SoftAssertions.assertSoftly {
                assertThat(firstCount).isEqualTo(1)
                assertThat(secondCount).isEqualTo(2)
            }
        }

        @Test
        fun `getCount returns 0 for missing Rank`() {
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
            val sut = WinningStatistics(mapOf(Rank.FIFTH to 1, Rank.NONE to 1))

            // Act
            val rate: Double = sut.profitRate()

            // Assert
            assertThat(rate).isCloseTo(250.0, within(0.00001))
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
