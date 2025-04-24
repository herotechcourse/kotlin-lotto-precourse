package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `valid winning lotto`() {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 45)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningLotto.winningLotto.getNumbers())
        assertEquals(45, winningLotto.bonusNumber)
    }

    @Test
    fun `throws an exception when bonus number not in range 1~45`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 46)
        }
    }

}