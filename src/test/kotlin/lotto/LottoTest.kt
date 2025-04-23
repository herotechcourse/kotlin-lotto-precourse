package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoTest {

    private val sut = Lotto(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `creates Lotto when numbers are valid`() {
        // Act
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(validNumbers)

        // Assert
        assertThat(lotto.getNumbers()).isEqualTo(validNumbers)
    }

    @Nested
    inner class ValidationTest {

        @Test
        fun `throws an exception when lotto numbers exceed six`() {
            // Arrange
            val exceedNumbers = listOf(1, 2, 3, 4, 5, 6, 7)

            // Act
            // Assert
            assertThatThrownBy { Lotto(exceedNumbers) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("Lotto must contain exactly")
        }

        @Test
        fun `throws an exception when lotto numbers contain duplicates`() {
            // Arrange
            val duplicateNumbers = listOf(1, 2, 3, 4, 5, 5)

            // Act
            // Assert
            assertThatThrownBy { Lotto(duplicateNumbers) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("Lotto numbers must be unique.")
        }

        @Test
        fun `throws an exception when any lotto number is below the valid range`() {
            // Arrange
            val invalidNumbers = listOf(0, 2, 3, 4, 5, 6)

            // Act
            // Assert
            assertThatThrownBy { Lotto(invalidNumbers) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("Lotto numbers must be between")
        }

        @Test
        fun `throws an exception when any lotto number is greater than 45`() {
            // Arrange
            val invalidNumbers = listOf(1, 2, 3, 4, 5, 46)

            // Act
            // Assert
            assertThatThrownBy { Lotto(invalidNumbers) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("Lotto numbers must be between")
        }
    }

    @Nested
    inner class MatchCountTest {

        @Test
        fun `matchCount returns 6 when there are all matched numbers`() {
            // Arrange
            val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

            // Act
            val result = sut.matchCount(winningLotto)

            // Assert
            assertThat(result).isEqualTo(6)
        }

        @Test
        fun `matchCount returns 0 when there are no matched numbers`() {
            // Arrange
            val winningLotto = Lotto(listOf(7, 8, 9, 10, 11, 12))

            // Act
            val result = sut.matchCount(winningLotto)

            // Assert
            assertThat(result).isEqualTo(0)
        }

    }


    @Nested
    inner class ContainsTest {

        @Test
        fun `contains returns true when bonus number is in the ticket`() {
            // Arrange
            val bonusNumber = 3

            // Act
            val containsBonus = sut.contains(bonusNumber)

            // Assert
            assertThat(containsBonus).isTrue()
        }

        @Test
        fun `contains returns false when bonus number is not in the ticket`() {
            // Arrange
            val bonusNumber = 10

            // Act
            val containsBonus: Boolean = sut.contains(bonusNumber)

            // Assert
            assertThat(containsBonus).isFalse()
        }

    }

    @Test
    fun `getNumbers returns a defensive copy of original numbers`() {
        // Arrange
        val originalNumbers = listOf(6, 1, 5, 3, 2, 4)
        val lotto = Lotto(originalNumbers)

        // Act
        val returnedNumbers = lotto.getNumbers()

        // Assert
        SoftAssertions.assertSoftly {
            assertThat(returnedNumbers).containsExactlyElementsOf(originalNumbers)
            assertThat(returnedNumbers).isNotSameAs(originalNumbers)
        }
    }

}
