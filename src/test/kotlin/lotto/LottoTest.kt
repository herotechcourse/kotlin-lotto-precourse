package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

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
    fun `matchCount returns the number of matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = setOf(1, 2, 7, 8, 9, 10)

        val count = lotto.matchCount(winningNumbers)

        assertEquals(2, count) // Matching numbers are 1 and 2
    }

    @Test
    fun `containsBonusNumber returns true if bonus number is contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertTrue(lotto.containsBonusNumber(6)) // 6 is contained
    }

    @Test
    fun `containsBonusNumber returns false if bonus number is not contained`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertFalse(lotto.containsBonusNumber(10)) // 10 is not contained
    }

    @Test
    fun `getNumbers returns sorted numbers`() {
        val lotto = Lotto(listOf(6, 1, 3, 2, 5, 4))

        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getNumbers())
    }

}
