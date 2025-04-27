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
    fun `throws an exception when numbers are not within 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `should create Lotto successfully with valid numbers`() {
        val lotto = Lotto(listOf(3, 4, 5, 6, 1, 2))
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `should correctly count the number of matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(2, 4, 6, 7, 8, 9)
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `should correctly know if bonus number is included`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.hasBonus(5)).isTrue()
        assertThat(lotto.hasBonus(7)).isFalse()
    }
}
