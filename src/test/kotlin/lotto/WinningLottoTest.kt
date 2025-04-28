package lotto

import lotto.domain.WinningLotto
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertNotNull

class WinningLottoTest {
    @Test
    fun `success case when winning Lotto is given 6 unique numbers and not duplicated with bonus number`() {
        // given
        val winningNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber: Int = 7

        // when
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)

        // then
        assertNotNull(winningLotto)
    }

    @Test
    fun `should throw exception when less than 6 winning numbers are given`() {
        // given
        val winningNumbers: List<Int> = listOf(1, 2, 3, 4, 5)
        val bonusNumber: Int = 7

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(winningNumbers, bonusNumber)
        }

        // then
        assertTrue(exception.message!!.equals("[ERROR] Winning Lotto must contain exactly 6 numbers."))
    }

    @Test
    fun `should throw exception when duplicate winning numbers are given`() {
        // given
        val winningNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 5)
        val bonusNumber: Int = 7

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(winningNumbers, bonusNumber)
        }

        // then
        assertTrue(exception.message!!.equals("[ERROR] Lotto numbers must be unique."))
    }

    @Test
    fun `should throw exception when winning numbers are out of range`() {
        // given
        val winningNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 55)
        val bonusNumber: Int = 7

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(winningNumbers, bonusNumber)
        }

        // then
        assertTrue(exception.message!!.equals("[ERROR] Lotto numbers must be between 1 and 45."))
    }

    @Test
    fun `should throw exception when bonus number is out of range`() {
        // given
        val winningNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber: Int = 47

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(winningNumbers, bonusNumber)
        }

        // then
        assertTrue(exception.message!!.equals("[ERROR] Bonus number must be between 1 and 45."))
    }

    @Test
    fun `should throw exception when bonus number is duplicated with winning numbers`() {
        // given
        val lotto = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber: Int = 6

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(lotto, bonusNumber)
        }

        // then
        assertTrue(exception.message!!.equals("[ERROR] Winning numbers must not contain bonus number."))
    }
}