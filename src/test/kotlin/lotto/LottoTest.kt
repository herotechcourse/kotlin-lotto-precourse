package lotto

import lotto.core.constant.ErrorMessage.ErrorMessages.NUMBERS_RANGE_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.NUMBERS_SIZE_ERROR
import lotto.core.constant.ErrorMessage.ErrorMessages.NUMBERS_UNIQUE_ERROR
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
    fun `valid numbers should create Lotto`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals(numbers, lotto.getNumbers())
    }

    @Test
    fun `init should throw when size is not 6`() {
        val tooFew = listOf(1, 2, 3, 4, 5)
        val ex = assertThrows<IllegalArgumentException> {
            Lotto(tooFew)
        }
        assertEquals(NUMBERS_SIZE_ERROR, ex.message)
    }

    @Test
    fun `init should throw when numbers are not unique`() {
        val dupes = listOf(1, 1, 2, 3, 4, 5)
        val ex = assertThrows<IllegalArgumentException> {
            Lotto(dupes)
        }
        assertEquals(NUMBERS_UNIQUE_ERROR, ex.message)
    }

    @Test
    fun `init should throw when any number is out of range`() {
        val outOfRange = listOf(0, 2, 3, 4, 5, 6)
        val ex = assertThrows<IllegalArgumentException> {
            Lotto(outOfRange)
        }
        assertEquals(NUMBERS_RANGE_ERROR, ex.message)
    }

    @Test
    fun `countMatching should return number of matching numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winning = listOf(4, 5, 6, 7, 8, 9)
        assertEquals(3, lotto.countMatching(winning))
    }

    @Test
    fun `hasBonus should return true only when the bonus number is present`() {
        val lotto = Lotto(listOf(10, 20, 30, 40, 41, 42))
        assertTrue(lotto.hasBonus(40))
        assertFalse(lotto.hasBonus(1))
    }

    @Test
    fun `toString should return the numbers list representation`() {
        val numbers = listOf(5, 10, 15, 20, 25, 30)
        val lotto = Lotto(numbers)
        assertEquals(numbers.toString(), lotto.toString())
    }}
