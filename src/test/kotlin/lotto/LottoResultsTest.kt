package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoResultsTest {
    @Test
    fun `the value of map starts from 0`() {
        val lottoResults = LottoResults()
        assertThat(0).isEqualTo(lottoResults.getMatchResult(LottoRanks.MATCH_3))
    }

    @Test
    fun `The value should increase after the function is called`() {
        val lottoResults = LottoResults()
        lottoResults.increaseMatchResult(LottoRanks.MATCH_3)
        lottoResults.increaseMatchResult(LottoRanks.MATCH_4)
        lottoResults.increaseMatchResult(LottoRanks.MATCH_4)
        assertThat(1).isEqualTo(lottoResults.getMatchResult(LottoRanks.MATCH_3))
        assertThat(2).isEqualTo(lottoResults.getMatchResult(LottoRanks.MATCH_4))
    }

    @Test
    fun `should count return rate`() {
        val lottoResults = LottoResults()
        lottoResults.increaseMatchResult(LottoRanks.MATCH_3)
        val returnRate = lottoResults.countReturnRate(5000)
        assertThat(returnRate).isEqualTo(100.0)
    }
}