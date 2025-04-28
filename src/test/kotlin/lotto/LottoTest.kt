package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

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

    // TODO: Implement tests based on the added features
    @Test
    fun `matchCount returns correct number of matches`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 7, 8, 9, 10)
        assertEquals(2, lotto.matchCount(winningNumbers))
    }
    @Test
    fun `containsBonus returns true if bonus number is in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(true, lotto.containsBonus(6))
    }
    @Test
    fun `containsBonus returns false if bonus number is not in lotto`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(false, lotto.containsBonus(10))
    }
}
