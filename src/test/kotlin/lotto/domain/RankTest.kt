package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `6개 일치하면 1등`() {
        val rank = Rank.of(6, false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `5개 일치 + 보너스 일치하면 2등`() {
        val rank = Rank.of(5, true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `5개만 일치하면 3등`() {
        val rank = Rank.of(5, false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `4개 일치하면 4등`() {
        val rank = Rank.of(4, false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `3개 일치하면 5등`() {
        val rank = Rank.of(3, false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `2개 이하이면 당첨없음`() {
        val rank = Rank.of(2, false)
        assertThat(rank).isEqualTo(Rank.NONE)
    }
}
