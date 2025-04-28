package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LottoTest {

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `counts matches correctly`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        assertEquals(3, lotto.countMatches(winningNumbers))
    }

    @Test
    fun `checks if number is contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.contains(1))
        assertFalse(lotto.contains(7))
    }

    @Test
    fun `returns sorted numbers`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getNumbers())
    }
}