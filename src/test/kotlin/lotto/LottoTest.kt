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
    fun `throws an exception when lotto numbers are out of valid range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `creates a Lotto successfully when numbers are valid`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `Lotto should sort numbers in ascending order`() {
        val lotto = Lotto(listOf(6, 1, 3, 2, 5, 4))

        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    fun `counts matching numbers correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 7, 8, 9, 10)

        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(2)
    }

    @Test
    fun `returns true if bonus number exists`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = 5

        assertThat(lotto.containsBonus(bonus)).isTrue()
    }

    @Test
    fun `returns false if bonus number does not exist`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = 7

        assertThat(lotto.containsBonus(bonus)).isFalse()
    }
}