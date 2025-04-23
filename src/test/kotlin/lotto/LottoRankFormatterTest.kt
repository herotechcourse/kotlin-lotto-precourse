package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankFormatterTest {

    @Test
    fun `formats description correctly without bonus`() {
        val result = LottoRankFormatter.formatDescription(3, false, 5000)
        assertThat(result).isEqualTo("3 Matches (5,000 KRW)")
    }

    @Test
    fun `formats description correctly with bonus`() {
        val result = LottoRankFormatter.formatDescription(5, true, 30000000)
        assertThat(result).isEqualTo("5 Matches + Bonus Ball (30,000,000 KRW)")
    }
}