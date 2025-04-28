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
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `returns correct matching count when compared with another Lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val other = Lotto(listOf(4, 5, 6, 7, 8, 9))

        val matchCount = lotto.matchCount(other)

        assertThat(matchCount).isEqualTo(3)  //4, 5, 6
    }

    @Test
    fun `returns zero when no numbers match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val other = Lotto(listOf(7, 8, 9, 10, 11, 12))

        val matchCount = lotto.matchCount(other)

        assertThat(matchCount).isEqualTo(0)
    }
}
