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
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `returns correct match count with winning numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)

        val matchCount = lotto.matchCount(winningNumbers)

        assertThat(matchCount).isEqualTo(3)
    }

    @Test
    fun `returns true when lotto contains the number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto.contains(1)).isTrue()
        assertThat(lotto.contains(7)).isFalse()
    }

    @Test
    fun `creates valid lotto with correct numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotto).isNotNull()
    }

    @Test
    fun `correctly formats lotto numbers as string`() {
        val lotto = Lotto(listOf(6, 3, 1, 5, 4, 2))

        val lottoString = lotto.toString()

        assertThat(lottoString).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }
}