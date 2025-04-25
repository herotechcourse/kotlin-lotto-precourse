package lotto.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MatchPrizeTest {

    @Test
    fun `TEST returns SIX when 6 matches and no bonus`() {
        val prize = MatchPrize.from(6, false)
        assertThat(prize).isEqualTo(MatchPrize.SIX)
    }

    @Test
    fun `TEST returns FIVEWITHBONUS when 5 matches and bonus is true`() {
        val prize = MatchPrize.from(5, true)
        assertThat(prize).isEqualTo(MatchPrize.FIVEWITHBONUS)
    }

    @Test
    fun `TEST returns FIVE when 5 matches and no bonus`() {
        val prize = MatchPrize.from(5, false)
        assertThat(prize).isEqualTo(MatchPrize.FIVE)
    }

    @Test
    fun `TEST returns FOUR when 4 matches`() {
        val prize = MatchPrize.from(4, false)
        assertThat(prize).isEqualTo(MatchPrize.FOUR)
    }

    @Test
    fun `TEST returns THREE when 3 matches`() {
        val prize = MatchPrize.from(3, false)
        assertThat(prize).isEqualTo(MatchPrize.THREE)
    }

    @Test
    fun `TEST returns NONE when less than 3 matches`() {
        assertThat(MatchPrize.from(2, false)).isEqualTo(MatchPrize.NONE)
        assertThat(MatchPrize.from(1, false)).isEqualTo(MatchPrize.NONE)
        assertThat(MatchPrize.from(0, false)).isEqualTo(MatchPrize.NONE)
    }
}
