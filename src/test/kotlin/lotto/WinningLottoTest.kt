package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `throws an exception when lotto numbers exceed six`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6, 7), 8)
        }
    }

    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 5), 8)
        }
    }

    @Test
    fun `throws an exception when lotto numbers is less than six`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5), 8)
        }
    }

    @Test
    fun `throws an exception when lotto number is out of the range of 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 46), 8)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of the range of 1 to 45`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `throws an exception when bonus number is include in the winning number`() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `evaluateLotto method returns FIRST_PRIZE if all six numbers match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)

        val evaluateLotto = winningLotto.evaluateLotto(lottoNumbers)

        assertEquals(evaluateLotto, LottoResultType.FIRST_PRIZE)
    }

    @Test
    fun `evaluateLotto method returns SECOND_PRIZE if five numbers and bonus number match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 7)

        val evaluateLotto = winningLotto.evaluateLotto(lottoNumbers)

        assertEquals(evaluateLotto, LottoResultType.SECOND_PRIZE)
    }

    @Test
    fun `evaluateLotto method returns THIRD_PRIZE if five numbers match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 8)

        val evaluateLotto = winningLotto.evaluateLotto(lottoNumbers)

        assertEquals(evaluateLotto, LottoResultType.THIRD_PRIZE)
    }

    @Test
    fun `evaluateLotto method returns FOURTH_PRIZE if four numbers match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumbers = listOf(1, 2, 3, 4, 8, 9)

        val evaluateLotto = winningLotto.evaluateLotto(lottoNumbers)

        assertEquals(evaluateLotto, LottoResultType.FOURTH_PRIZE)
    }

    @Test
    fun `evaluateLotto method returns FIFTH_PRIZE if three numbers match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumbers = listOf(1, 2, 3, 8, 9, 10)

        val evaluateLotto = winningLotto.evaluateLotto(lottoNumbers)

        assertEquals(evaluateLotto, LottoResultType.FIFTH_PRIZE)
    }

    @Test
    fun `returns NO_PRIZE when less than three numbers match`() {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottoNumbers = listOf(1, 2, 8, 9, 10, 11)

        val evaluateLotto = winningLotto.evaluateLotto(lottoNumbers)

        assertEquals(evaluateLotto, LottoResultType.NO_PRIZE)
    }

}