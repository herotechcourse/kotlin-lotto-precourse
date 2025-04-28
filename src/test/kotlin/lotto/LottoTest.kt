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

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are below range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are above range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `creates valid lotto with correct numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.getNumbers()).isEqualTo(numbers)
    }

    @Test
    fun `countMatches returns correct count of matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 3, 5, 7, 9, 11)
        assertThat(lotto.countMatches(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `countMatches returns zero when no matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)
        assertThat(lotto.countMatches(winningNumbers)).isEqualTo(0)
    }

    @Test
    fun `countMatches returns six when all numbers match`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertThat(lotto.countMatches(numbers)).isEqualTo(6)
    }

    @Test
    fun `hasBonus returns true when bonus number is present`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.hasBonus(6)).isTrue()
    }

    @Test
    fun `hasBonus returns false when bonus number is absent`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.hasBonus(7)).isFalse()
    }

    @Test
    fun `numbers are stored in original order`() {
        val numbers = listOf(6, 5, 4, 3, 2, 1)
        val lotto = Lotto(numbers)
        assertThat(lotto.getNumbers()).isEqualTo(numbers)
    }


}
