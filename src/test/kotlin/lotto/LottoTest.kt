package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

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
    fun `creates Lotto successfully when numbers are valid`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString())
    }

    @Test
    fun `matchCount returns correct number of matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 10, 20, 30))
        val winningNumbers = listOf(1, 2, 10, 40, 41, 42)
        assertEquals(3, lotto.matchCount(winningNumbers))
    }

    @Test
    fun `contains returns true if number exists`() {
        val lotto = Lotto(listOf(1, 2, 3, 10, 20, 30))
        assertEquals(true, lotto.contains(10))
    }

    @Test
    fun `contains returns false if number does not exist`() {
        val lotto = Lotto(listOf(1, 2, 3, 10, 20, 30))
        assertEquals(false, lotto.contains(40))
    }
}
