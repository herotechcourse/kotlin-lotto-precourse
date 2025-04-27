package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

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
    fun `throws an exception when lotto number is less than 1`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto number is greater than 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `creates lotto successfully with valid numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `getNumbers returns unmodifiable list`() {
        val originalNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(originalNumbers)

        // Verify that the returned list contains the same elements
        assertThat(lotto.getNumbers()).containsExactlyElementsOf(originalNumbers)

        // Verify that modifying the original list doesn't affect the lotto numbers
        val mutableOriginal = originalNumbers.toMutableList()
        mutableOriginal[0] = 10
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `toString returns correct string representation`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `creates lotto successfully with unsorted numbers and maintains order`() {
        val lotto = Lotto(listOf(6, 1, 3, 5, 4, 2))
        assertThat(lotto.getNumbers()).containsExactly(6, 1, 3, 5, 4, 2)
    }

    @Test
    fun `creates lotto successfully with boundary values`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 45))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 45)
    }
}
