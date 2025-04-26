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
    fun `countMatchingNumbers returns correct count when all numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(6)
    }

    @Test
    fun `countMatchingNumbers returns correct count when no numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(7, 8, 9, 10, 11, 12)
        assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(0)
    }

    @Test
    fun `countMatchingNumbers returns correct count when some numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        assertThat(lotto.countMatchingNumbers(winningNumbers)).isEqualTo(3)
    }

    @Test
    fun `containsBonusNumber returns true when bonus number is in ticket`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.containsBonusNumber(1)).isTrue()
    }

    @Test
    fun `containsBonusNumber returns false when bonus number is not in ticket`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.containsBonusNumber(7)).isFalse()
    }
}
