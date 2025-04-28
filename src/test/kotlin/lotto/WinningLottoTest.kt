package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `throw an exception when bonus number is not in range 1 and 45 inclusive`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> {
            WinningLotto(numbers, 0)
        }

        assertThrows<IllegalArgumentException> {
            WinningLotto(numbers, 46)
        }
    }

    @Test
    fun `throw an exception when bonus number is a duplicate with a number in winning numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> {
            WinningLotto(numbers, 6)
        }
    }

    @Test
    fun `matchCount() - return count of matching numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(numbers, 7)

        val userLotto = Lotto(listOf(1, 2, 3, 10, 20, 30))
        assertEquals(3, winningLotto.matchCount(userLotto))
    }

    @Test
    fun `isMatchBonusNumber() - return true or false when bonus number match or not match within winning numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(numbers, 7)

        val userLottoTrue = Lotto(listOf(1, 2, 3, 7, 8, 9))
        val userLottoFalse = Lotto(listOf(1, 2, 3, 10, 20, 30))

        assertTrue(winningLotto.isMatchBonusNumber(userLottoTrue))
        assertFalse(winningLotto.isMatchBonusNumber(userLottoFalse))
    }

    @Test
    fun `match() - return matching Rank of given lotto ticket`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        val userLottoCaseFirst = Lotto(winningNumbers)
        val userLottoCaseSecond = Lotto(listOf(1, 2, 3, 4, 5, bonusNumber))
        val userLottoCaseThird = Lotto(listOf(1, 2, 3, 4, 5, 8))
        val userLottoCaseFourth = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val userLottoCaseFifth = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val userLottoCaseNone1 = Lotto(listOf(1, 2, 8, 9, 10, 11))
        val userLottoCaseNone2 = Lotto(listOf(1, 8, 9, 10, 11, 12))
        val userLottoCaseNone3 = Lotto(listOf(8, 9, 10, 11, 12, 13))

        assertEquals(Rank.FIRST, winningLotto.match(userLottoCaseFirst))
        assertEquals(Rank.SECOND, winningLotto.match(userLottoCaseSecond))
        assertEquals(Rank.THIRD, winningLotto.match(userLottoCaseThird))
        assertEquals(Rank.FOURTH, winningLotto.match(userLottoCaseFourth))
        assertEquals(Rank.FIFTH, winningLotto.match(userLottoCaseFifth))
        assertEquals(Rank.NONE, winningLotto.match(userLottoCaseNone1))
        assertEquals(Rank.NONE, winningLotto.match(userLottoCaseNone2))
        assertEquals(Rank.NONE, winningLotto.match(userLottoCaseNone3))
    }
}