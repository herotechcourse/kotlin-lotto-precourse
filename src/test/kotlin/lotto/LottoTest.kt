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
    fun `matchCount counts matching numbers correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)

        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `containsBonus detects bonus number correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.containsBonus(6)).isTrue()
        assertThat(lotto.containsBonus(7)).isFalse()
    }
}
