package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*

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
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6)) // 0 is invalid
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46)) // 46 is invalid
        }
    }

    @Test
    fun `creates a valid Lotto when six unique numbers between 1 and 45 are given`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val numbers = lotto.getNumbers()
        assertEquals(6, numbers.size)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), numbers) // should be sorted
    }

    @Test
    fun `lotto numbers should always be sorted`() {
        val lotto = Lotto(listOf(6, 1, 5, 2, 4, 3))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getNumbers())
    }
}
