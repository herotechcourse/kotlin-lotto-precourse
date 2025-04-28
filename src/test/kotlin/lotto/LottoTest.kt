package lotto

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
    fun `returns correct match count and bonus match when matching 6 numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val (matchCount, matchedBonus) = lotto.matchCount(listOf(1, 2, 3, 4, 5, 6), 7)

        assertEquals(6, matchCount)
        assertEquals(false, matchedBonus)
    }

    @Test
    fun `returns correct match count and no bonus when matching 5 numbers but no bonus`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val (matchCount, matchedBonus) = lotto.matchCount(listOf(1, 2, 3, 4, 5, 6), 7)

        assertEquals(4, matchCount)
        assertEquals(false, matchedBonus)
    }
    @Test
    fun `returns zero match and no bonus when matching no numbers`() {
        val lotto = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val (matchCount, matchedBonus) = lotto.matchCount(listOf(1, 2, 3, 4, 5, 6), 7)

        assertEquals(0, matchCount)
        assertEquals(false, matchedBonus)
    }
    @Test
    fun `returns correct match count and bonus match when matching 5 numbers and bonus`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7)) // <-- include 1,2,3,4,5, and bonus 7
        val (matchCount, matchedBonus) = lotto.matchCount(listOf(1, 2, 3, 4, 5, 6), 7)

        assertEquals(5, matchCount)
        assertEquals(true, matchedBonus)
    }
}
