package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class LottoTest {
    @Test
    fun `creates a lotto ticket successfully when numbers are valid`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assert(lotto.getSortedNumbers() == listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws an exception when lotto numbers are fewer than six`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain numbers smaller than 1`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain numbers greater than 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(46, 2, 3, 4, 5, 6))
        }
    }

    @Test
    fun `returns correct match count between two lottos`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val user = Lotto(listOf(1, 2, 3, 7, 8, 9))

        val matchCountMethod = user.javaClass.getDeclaredMethod("matchCount", Lotto::class.java)
        matchCountMethod.isAccessible = true
        val result = matchCountMethod.invoke(user, winningNumbers) as Int

        assertEquals(3, result)
    }

    @Test
    fun `correctly checks if lotto contains a number`() {
        val lotto = Lotto(listOf(10, 11, 12, 13, 14, 15))
        assertEquals(true, lotto.contains(13))
        assertEquals(false, lotto.contains(1))
    }

    @Test
    fun `returns correct prize rank based on match and bonus`() {
        val winning = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonus = 7

        val firstPrize = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val secondPrize = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val thirdPrize = Lotto(listOf(1, 2, 3, 4, 5, 45))
        val fourthPrize = Lotto(listOf(1, 2, 3, 4, 44, 45))
        val fifthPrize = Lotto(listOf(1, 2, 3, 43, 44, 45))
        val noPrize = Lotto(listOf(10, 20, 30, 40, 41, 42))

        assertEquals(1, firstPrize.prizeCount(winning, bonus))
        assertEquals(2, secondPrize.prizeCount(winning, bonus))
        assertEquals(3, thirdPrize.prizeCount(winning, bonus))
        assertEquals(4, fourthPrize.prizeCount(winning, bonus))
        assertEquals(5, fifthPrize.prizeCount(winning, bonus))
        assertEquals(0, noPrize.prizeCount(winning, bonus))
    }
}
