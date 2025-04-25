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
    fun `throws an exception when lotto numbers are less then six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `creates a Lotto successfully when numbers are six and unique`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto).isNotNull
    }

    @Test
    fun `returns the count of same numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val count = lotto.countMatches(listOf(1,2,3,7,8,9))
        assertThat(count).isEqualTo(3)
    }

    @Test
    fun `returns true if number exists`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val containNumber = lotto.contains(5)
        assertThat(containNumber).isEqualTo(true)
    }
}
