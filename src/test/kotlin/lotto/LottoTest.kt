package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `creates a lotto ticket successfully when numbers are valid`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assert(lotto.numberList == listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are fewer than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain numbers smaller than 1`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain numbers greater than 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46, 2, 3, 4, 5, 6))
        }
    }
}
