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

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 51, 5))
        }
    }

    @Test
    fun `should return correct match count and bonus match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 7, 8, 9)
        val bonusNumber = 4

        val result = lotto.matchingNumberCount(winningNumbers, bonusNumber)

        assertEquals(3, result.first) // 3 matches (1, 2, 3)
        assertEquals(true, result.second) // No bonus match
    }

    @Test
    fun `should return correct match count with bonus match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 7, 8)
        val bonusNumber = 4

        val result = lotto.matchingNumberCount(winningNumbers, bonusNumber)

        assertEquals(4, result.first) // 3 matches (1, 2, 3)
        assertEquals(true, result.second) // Bonus match (4)
    }

    @Test
    fun `should return zero matches and no bonus match`() {
        val lotto = Lotto(listOf(10, 11, 12, 13, 14, 15))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = lotto.matchingNumberCount(winningNumbers, bonusNumber)

        assertEquals(0, result.first) // No matches
        assertEquals(false, result.second) // No bonus match
    }

    @Test
    fun `should return correct match count with no bonus number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = lotto.matchingNumberCount(winningNumbers, bonusNumber)

        assertEquals(6, result.first) // All numbers match
        assertEquals(false, result.second) // No bonus match
    }
}
