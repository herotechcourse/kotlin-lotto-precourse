package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `returns FIRST rank when 6 numbers match`() {
        val rank = Rank.from(matchCount = 6, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns SECOND rank when 5 numbers match and bonus matches`() {
        val rank = Rank.from(matchCount = 5, matchBonus = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns THIRD rank when 5 numbers match without bonus`() {
        val rank = Rank.from(matchCount = 5, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns FOURTH rank when 4 numbers match`() {
        val rank = Rank.from(matchCount = 4, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns FIFTH rank when 3 numbers match`() {
        val rank = Rank.from(matchCount = 3, matchBonus = false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns NONE rank when less than 3 numbers match`() {
        assertThat(Rank.from(2, matchBonus = false)).isEqualTo(Rank.NONE)
        assertThat(Rank.from(1, matchBonus = false)).isEqualTo(Rank.NONE)
        assertThat(Rank.from(0, matchBonus = false)).isEqualTo(Rank.NONE)
    }

    @Test
    fun `each rank has correct prize amount`() {
        assertThat(Rank.FIRST.prize).isEqualTo(LottoConstants.LOTTO_FIRST_PRIZE_AMOUNT)
        assertThat(Rank.SECOND.prize).isEqualTo(LottoConstants.LOTTO_SECOND_PRIZE_AMOUNT)
        assertThat(Rank.THIRD.prize).isEqualTo(LottoConstants.LOTTO_THIRD_PRIZE_AMOUNT)
        assertThat(Rank.FOURTH.prize).isEqualTo(LottoConstants.LOTTO_FOURTH_PRIZE_AMOUNT)
        assertThat(Rank.FIFTH.prize).isEqualTo(LottoConstants.LOTTO_FIFTH_PRIZE_AMOUNT)
        assertThat(Rank.NONE.prize).isEqualTo(LottoConstants.LOTTO_NONE_PRIZE_AMOUNT)
    }
}