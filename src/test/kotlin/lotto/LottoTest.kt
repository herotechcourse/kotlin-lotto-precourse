package lotto

import lotto.services.LottoResult
import lotto.services.Prize
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

    @Test
    fun `calculates result for first prize`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val lottoResult = LottoResult(tickets, winningNumbers, bonusNumber)

        val result = lottoResult.getResult()
        assert(result[Prize.FIRST] == 1)
    }

    @Test
    fun `calculates result for second prize`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val lottoResult = LottoResult(tickets, winningNumbers, bonusNumber)

        val result = lottoResult.getResult()
        assert(result[Prize.SECOND] == 1)
    }

    @Test
    fun `calculates result for third prize`() {
        val tickets = listOf(Lotto(listOf(1, 2, 3, 4, 5, 8)))
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val lottoResult = LottoResult(tickets, winningNumbers, bonusNumber)

        val result = lottoResult.getResult()

        assert(result[Prize.THIRD] == 1)
    }

}

