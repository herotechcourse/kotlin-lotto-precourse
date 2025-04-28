package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningRankTest {
    @Test
    fun `from method should return the correct WinningRank based on matchCount and bonus`() {
        assertThat(WinningRank.FIRST).isEqualTo(WinningRank.from(6, false))
        assertThat(WinningRank.SECOND).isEqualTo(WinningRank.from(5, true))
        assertThat(WinningRank.THIRD).isEqualTo(WinningRank.from(5, false))
        assertThat(WinningRank.FOURTH).isEqualTo(WinningRank.from(4, false))
        assertThat(WinningRank.FIFTH).isEqualTo(WinningRank.from(3, false))
        assertThat(WinningRank.MISS).isEqualTo(WinningRank.from(2, false))
    }
}