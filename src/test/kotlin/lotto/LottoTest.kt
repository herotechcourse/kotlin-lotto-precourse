package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
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
    fun `throws an exception when lotto numbers are out of valid range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `getSortedNumbers should return numbers in ascending order`() {
        val lotto = Lotto(listOf(6, 2, 4, 5, 1, 3))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getSortedNumbers())
    }

    @Test
    fun `countingWinningNumbers should return count of matched numbers`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winning = listOf(2, 3, 7, 8, 9, 10)
        assertEquals(2, lotto.countingWinningNumbers(winning))
    }

    @Test
    fun `isContainsBonusNumber should return true if bonus number exists`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.isContainsBonusNumber(3))
    }

    @Test
    fun `isContainsBonusNumber should return false if bonus number does not exist`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(!lotto.isContainsBonusNumber(7))
    }

    @Test
    fun `throws an exception when lotto numbers are less than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto number is below minimum range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when lotto number is above maximum range`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 46))
        }
    }

    @Test
    fun `throws an exception when lotto number includes multiple invalid values`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(-1, 0, 3, 44, 46, 100))
        }
    }

    @Test
    fun `throws an exception when all numbers are the same`() {
        assertThrows<IllegalArgumentException> {
            Lotto(List(6) { 5 })
        }
    }


    @Test
    fun `lotto should not be affected by order of input numbers`() {
        val lottoA = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoB = Lotto(listOf(6, 5, 4, 3, 2, 1))
        assertEquals(lottoA.getSortedNumbers(), lottoB.getSortedNumbers())
    }

    @Test
    fun `countingWinningNumbers should return 0 when there is no match`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winning = listOf(11, 12, 13, 14, 15, 16)
        assertEquals(0, lotto.countingWinningNumbers(winning))
    }

    @Test
    fun `countingWinningNumbers should return 6 when all numbers match`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(numbers)
        assertEquals(6, lotto.countingWinningNumbers(numbers))
    }

}