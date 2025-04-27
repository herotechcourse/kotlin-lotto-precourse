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
    fun `throws an exception when lotto numbers are not within 1 and 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 55, 5))
        }
    }

    @Test
    fun `should return Lotto numbers in sorted order`() {
        val lotto = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertEquals(lotto.getNumbers(), listOf<Int>(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `should return match count`() {
        val lotto1 = Lotto(listOf(1, 2, 8, 4, 5, 6))
        val lotto2 = Lotto(listOf(1, 2, 3, 4, 5, 6))

        val matchCount = lotto1.matchCount(lotto2)

        assertEquals(5, matchCount)  // All numbers match
    }

    @Test
    fun `should return true if Lotto contains the number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(true, lotto.contains(3))
    }

    @Test
    fun `should return false if Lotto does not contain the number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(false, lotto.contains(7))
    }
}
