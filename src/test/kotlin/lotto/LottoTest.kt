package lotto

import lotto.domain.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
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
    fun `returns correct matching number count`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)

        val matchCount = lotto.countMatchingNumbers(winningNumbers)

        assertEquals(3, matchCount)
    }

    @Test
    fun `correctly checks if bonus number exists`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertEquals(true, lotto.contains(6))
        assertEquals(false, lotto.contains(7))
    }
}
