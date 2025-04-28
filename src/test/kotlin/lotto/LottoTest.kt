package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
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

    fun `If the lotto number is not 6, an exception is thrown다`() {
        val numbers = listOf(1, 2, 3, 4, 5)

        val exception = assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }

        assertEquals("[ERROR] Lotto must contain exactly 6 numbers.", exception.message)
    }

    @Test
    fun `containBonus returns true if it contains a bonus number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val containsBonus = lotto.containBonus(5)
        assertTrue(containsBonus)
    }

    @Test
    fun `containBonus returns false if it does not contain a bonus number`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val containsBonus = lotto.containBonus(7)
        assertFalse(containsBonus)
    }
}
