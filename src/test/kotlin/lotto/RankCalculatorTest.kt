package lotto

import lotto.domain.Rank
import lotto.domain.RankCalculator
import lotto.domain.WinningNumbers
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RankCalculatorTest {
    @Test
    fun `returns FIFTH rank when all six numbers match`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val rank = RankCalculator.calculate(lotto, winningNumbers)

        // Then
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns FOURTH rank when five numbers match and bonus matches`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val rank = RankCalculator.calculate(lotto, winningNumbers)

        // Then
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns THIRD rank when five numbers match without bonus`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val rank = RankCalculator.calculate(lotto, winningNumbers)

        // Then
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns SECOND rank when four numbers match`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val rank = RankCalculator.calculate(lotto, winningNumbers)

        // Then
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns FIRST rank when three numbers match`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val rank = RankCalculator.calculate(lotto, winningNumbers)

        // Then
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns NONE rank when less than three numbers match`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 8, 9, 10, 11))
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)

        // When
        val rank = RankCalculator.calculate(lotto, winningNumbers)

        // Then
        assertThat(rank).isEqualTo(Rank.NONE)
    }
}