package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningLottoTest {

    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val sut = WinningLotto(Lotto(winningNumbers), 7)

    @Nested
    inner class ValidationTest {

        private val winningLotto = Lotto(winningNumbers)

        @ParameterizedTest
        @ValueSource(ints = [0, 46])
        fun `throws an exception when bonus number is not in valid range`(invalidBonus: Int) {
            // Act
            // Assert
            assertThatThrownBy { WinningLotto(winningLotto, invalidBonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Bonus number must be between")
        }

        @Test
        fun `throws an exception when bonus number is included in winning numbers`() {
            // Arrange
            val duplicateBonus = 6

            // Act
            // Assert
            assertThatThrownBy { WinningLotto(winningLotto, duplicateBonus) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Bonus number must not be included in the winning numbers.")
        }
    }

    @Nested
    inner class RankMatchingTest {

        @Test
        fun `returns FIRST when all numbers match`() {
            // Arrange
            val userLotto = Lotto(winningNumbers)

            // Act
            val result: Rank = sut.match(userLotto)

            // Assert
            assertThat(result).isEqualTo(Rank.FIRST)
        }

        @Test
        fun `returns SECOND when 5 numbers and bonus match`() {
            // Arrange
            val userLotto = Lotto(listOf(1, 2, 3, 4, 5, 7))

            // Act
            val result: Rank = sut.match(userLotto)

            // Assert
            assertThat(result).isEqualTo(Rank.SECOND)
        }

        @Test
        fun `returns THIRD when 5 numbers match and bonus does not match`() {
            // Arrange
            val userLotto = Lotto(listOf(1, 2, 3, 4, 5, 45))

            // Act
            val result: Rank = sut.match(userLotto)

            // Assert
            assertThat(result).isEqualTo(Rank.THIRD)
        }

        @Test
        fun `returns FOURTH when 4 numbers match`() {
            // Arrange
            val userLotto = Lotto(listOf(1, 2, 3, 4, 44, 45))

            // Act
            val result: Rank = sut.match(userLotto)

            // Assert
            assertThat(result).isEqualTo(Rank.FOURTH)
        }

        @Test
        fun `returns FIFTH when 3 numbers match`() {
            // Arrange
            val userLotto = Lotto(listOf(1, 2, 3, 7, 44, 45))

            // Act
            val result: Rank = sut.match(userLotto)

            // Assert
            assertThat(result).isEqualTo(Rank.FIFTH)
        }

        @Test
        fun `returns NONE when less than 3 numbers match`() {
            // Arrange
            val userLotto = Lotto(listOf(7, 41, 42, 43, 44, 45))

            // Act
            val result: Rank = sut.match(userLotto)

            // Assert
            assertThat(result).isEqualTo(Rank.NONE)
        }
    }
}
