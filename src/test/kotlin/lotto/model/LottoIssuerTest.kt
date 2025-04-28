package lotto.model

import lotto.constants.Constants
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoIssuerTest {
    @Test
    fun `returns the correct number of lottery`() {
        val lottoCount = 29
        val lottery = LottoIssuer.execute(lottoCount)
        assertEquals(lottoCount, lottery.size)
    }

    @Test
    fun `each lotto should be sorted in ascending order`() {
        val lottery = LottoIssuer.execute(100)

        for (lotto in lottery) {
            val numbers = lotto.getNumbers()
            assertEquals(numbers.sorted(), numbers)
        }
    }

    @Test
    fun `each lotto should contain 6 unique numbers within range`() {
        val lottery = LottoIssuer.execute(100)

        for (lotto in lottery) {
            val numbers = lotto.getNumbers()
            assertEquals(Constants.LOTTO_NUMBERS_COUNT, numbers.size)
            assertEquals(numbers.toSet().size, numbers.size)
            assertTrue(numbers.all { it in Constants.LOTTO_MIN_NUMBER..Constants.LOTTO_MAX_NUMBER })
        }
    }
}