package lotto.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `generates a list of unique lotto numbers`() {
        val lottoNumbers = LottoGenerator.generateLottoNumbers()
        assertEquals(6, lottoNumbers.size)
        assertTrue(lottoNumbers.distinct().size == lottoNumbers.size)
    }

    @Test
    fun `generates numbers within the valid range`() {
        val lottoNumbers = LottoGenerator.generateLottoNumbers()
        assertTrue(lottoNumbers.all { it in 1..45 })
    }

}