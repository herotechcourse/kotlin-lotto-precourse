package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class LottosTest {

    private val values = listOf(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),  // FIRST
        Lotto(listOf(1, 2, 3, 4, 5, 7)),  // SECOND
        Lotto(listOf(1, 2, 3, 4, 5, 8)),  // THIRD
        Lotto(listOf(1, 2, 3, 4, 10, 11)), // FOURTH
        Lotto(listOf(1, 2, 3, 10, 11, 12)), // FIFTH
        Lotto(listOf(10, 11, 12, 13, 14, 15)) // NONE
    )
    private val sut: Lottos = Lottos(values)
    private val winningLotto = WinningLotto(
        Lotto(listOf(1, 2, 3, 4, 5, 6)),
        bonusNumber = 7
    )

    @ParameterizedTest
    @EnumSource
    fun `matchAll returns correct counts of Ranks`(rank: Rank) {
        // Act
        val result: Map<Rank, Int> = sut.matchAll(winningLotto)

        // Assert
        assertThat(result[rank]).isEqualTo(1)
    }

    @Test
    fun `profitRate returns 0 when no ticket wins`() {
        // Arrange
        val sut = Lottos(List(2) { values[5] })

        // Act
        val rate: Double = sut.profitRate(winningLotto)

        // Assert
        assertThat(rate).isEqualTo(0.0)
    }

    @Test
    fun `profitRate returns partial rate when some tickets win`() {
        // Arrange
        val sut = Lottos(listOf(values[4], values[5]))

        // Act
        val rate: Double = sut.profitRate(winningLotto)

        // Assert
        assertThat(rate).isEqualTo(250.0)
    }

    @Test
    fun `size returns the number of Lotto tickets`() {
        // Act
        val size: Int = sut.size()

        // Assert
        assertThat(size).isEqualTo(values.size)
    }

    @Test
    fun `getValues returns a defensive copy of the internal list`() {
        // Act
        val result: List<Lotto> = sut.getValues()

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(result).containsExactlyElementsOf(values)
            assertThat(result).isNotSameAs(values)
        }
    }

    @Nested
    inner class EmptyLottosTest {

        private val emptyLottos = Lottos(emptyList())

        @Test
        fun `matchAll returns empty map when Lottos is empty`() {
            // Act
            val result: Map<Rank, Int> = emptyLottos.matchAll(winningLotto)

            // Assert
            assertThat(result).isEmpty()
        }

        @Test
        fun `profitRate returns 0 when Lottos is empty`() {
            // Act
            val profitRate: Double = emptyLottos.profitRate(winningLotto)

            // Assert
            assertThat(profitRate).isEqualTo(0.0)
        }

        @Test
        fun `size returns 0 when Lottos is empty`() {
            // Act
            val size: Int = emptyLottos.size()

            // Assert
            assertThat(size).isEqualTo(0)
        }

        @Test
        fun `getValues returns an empty list when Lottos is empty`() {
            // Act
            val values: List<Lotto> = emptyLottos.getValues()

            // Assert
            assertThat(values).isEmpty()
        }
    }

}
