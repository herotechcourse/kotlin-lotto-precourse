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
    fun `creates lotto correctly with six unique numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto).isNotNull()
    }

    @Test
    fun `lotto matchCount returns correct number of matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val matchCount = lotto.matchCount(winningNumbers)
        assertThat(matchCount).isEqualTo(3)
    }

    @Test
    fun `lotto containsBonus returns true when bonus is present`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonus = 7
        assertThat(lotto.containsBonus(bonus)).isTrue()
    }

    @Test
    fun `lotto containsBonus returns false when bonus is not present`() {
        val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val bonus = 10
        assertThat(lotto.containsBonus(bonus)).isFalse()
    }
}
