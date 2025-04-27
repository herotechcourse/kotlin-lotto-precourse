package lotto.input

import lotto.Lotto
import lotto.domain.WinningLotto
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberInputTest {
    @Test
    fun `should throw exception when Lotto is not given 6 unique numbers`() {
        // given
        val lottoNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }

        // then
        assertTrue(exception.message!!.contains("[ERROR]"))

    }

    @Test
    fun `should throw exception when less than 6 numbers are given`() {
        // given
        val lottoNumbers: List<Int> = listOf(1, 2, 3, 4, 5)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }

        // then
        assertTrue(exception.message!!.contains("[ERROR]"))
    }

    @Test
    fun `should throw exception when duplicate numbers are given`() {
        // given
        val lottoNumbers: List<Int> = listOf(1, 2, 3, 4, 6, 6)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }

        // then
        assertTrue(exception.message!!.contains("[ERROR]"))
    }

    @Test
    fun `should throw exception when numbers are out of range`() {
        // given
        val lottoNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 46)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }

        // then
        assertTrue(exception.message!!.contains("[ERROR]"))
    }

    @Test
    fun `should throw exception when bonus number is out of range`() {
        // given
        val lotto = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber: Int = 46

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(lotto, bonusNumber)
        }

        // then
        assertTrue(exception.message!!.contains("[ERROR]"))
    }

    @Test
    fun `should throw exception when bonus number is duplicated with main numbers`() {
        // given
        val lotto = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber: Int = 6

        // when
        val exception = assertThrows<IllegalArgumentException> {
            WinningLotto(lotto, bonusNumber)
        }

        // then
        assertTrue(exception.message!!.contains("[ERROR]"))
    }
}
