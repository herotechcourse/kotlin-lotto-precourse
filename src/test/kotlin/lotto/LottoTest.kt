package lotto

import lotto.Lotto
import org.junit.jupiter.api.Assertions.assertNotNull
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

    // TODO: Implement production code to pass the test
    @Test
    fun `throws an exception when lotto numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    // TODO: Implement tests based on the added features

    @Test
    fun `success case when Lotto is given 6 unique numbers`() {
        // given
        val lottoNumbers: List<Int> = listOf(1, 2, 3, 4, 5, 6)

        // when
        val lotto = Lotto(lottoNumbers)

        // then
        assertNotNull(lotto)
    }

    @Test
    fun `throw exception when less than 6 numbers are given`() {
        // given
        val lottoNumbers: List<Int> = listOf(1, 2, 3, 4, 5)

        // when
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(lottoNumbers)
        }

        // then
        assertTrue(exception.message!!.equals("[ERROR] Lotto must contain exactly 6 numbers."))
    }

}
