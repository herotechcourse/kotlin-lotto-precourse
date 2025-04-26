package lotto.model

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `success - creates WinningLotto successfully`() {
        val mainLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val winningLotto = WinningLotto(mainLotto, bonusNumber)

        assertEquals(mainLotto.getNumbers(), winningLotto.getWinningNumbers())
        assertEquals(bonusNumber, winningLotto.getBonusNumber())
    }

    @Test
    fun `exception - throws exception when bonus number is duplicated`() {
        val mainLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 3

        assertThrows<IllegalArgumentException> {
            WinningLotto(mainLotto, bonusNumber)
        }
    }

    @Test
    fun `exception - throws exception when bonus number is out of range`() {
        val mainLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

        assertThrows<IllegalArgumentException> {
            WinningLotto(mainLotto, 0)
        }

        assertThrows<IllegalArgumentException> {
            WinningLotto(mainLotto, -1)
        }

        assertThrows<IllegalArgumentException> {
            WinningLotto(mainLotto, 46)
        }
    }

    @Test
    fun `returns the correct winning numbers`() {
        val mainLotto = Lotto(listOf(11, 19, 23, 41, 45, 16))
        val bonusNumber = 44
        val winningLotto = WinningLotto(mainLotto, bonusNumber)

        assertEquals(mainLotto.getNumbers(), winningLotto.getWinningNumbers())
        assertEquals(bonusNumber, winningLotto.getBonusNumber())
    }
}
