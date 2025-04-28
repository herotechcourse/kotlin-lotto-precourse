package lotto.enums

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoRankTest {

    @Test
    @DisplayName("LottoRank Verification Test")
    fun `valueOfMatchCount first prize`() {
        val rank = LottoRank.valueOfMatchCount(6, false)

        assertThat(rank).isEqualTo(LottoRank.FIRST)
        assertThat(rank.prize).isEqualTo(2_000_000_000)
    }
}
