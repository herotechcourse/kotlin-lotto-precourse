package lotto

import org.junit.jupiter.api.Assertions.*
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
    fun `throws an exception when lotto numbers are not between 1 and 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }

        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `getNumbers returns sorted numbers`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getNumbers())
    }

    @Test
    fun `countMatches returns correct match count`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(3, lotto.countMatches(listOf(1, 2, 3, 7, 8, 9)))
        assertEquals(6, lotto.countMatches(listOf(1, 2, 3, 4, 5, 6)))
        assertEquals(0, lotto.countMatches(listOf(7, 8, 9, 10, 11, 12)))
    }

    @Test
    fun `contains returns true if number exists in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.containBonus(1))
        assertFalse(lotto.containBonus(7))
    }
}
