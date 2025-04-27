package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoEngineTest {

    @Test
    fun `calculate total winnings correctly`() {
        val engineResult = mapOf(
            Rank.FIRST to 1,
            Rank.FIFTH to 2
        )
        val totalWinnings = LottoEngine.totalResultWinnings(engineResult)

        assertThat(totalWinnings)
            .isEqualTo(2_000_000_000 + 5_000 * 2)
    }
}