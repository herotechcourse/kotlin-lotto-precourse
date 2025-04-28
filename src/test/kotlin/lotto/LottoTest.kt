package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto number is out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `matchCount returns correct number of matches`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12)

        // When
        val matchCount = lotto.matchCount(winningNumbers)

        // Then
        assertThat(matchCount).isEqualTo(3)
    }

    @Test
    fun `containsNumber returns true when number exists`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // When & Then
        assertThat(lotto.containsNumber(3)).isTrue()
    }

    @Test
    fun `containsNumber returns false when number does not exist`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // When & Then
        assertThat(lotto.containsNumber(7)).isFalse()
    }

    @Test
    fun `toString returns formatted string representation`() {
        // Given
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        // When
        val result = lotto.toString()

        // Then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }
}
