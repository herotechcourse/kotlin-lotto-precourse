package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {

    @Test
    fun `returns correct rank for match count and bonus`() {
        // First rank (6 matches)
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST) // Bonus doesn't matter for first rank

        // Second rank (5 matches + bonus)
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND)

        // Third rank (5 matches)
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD)

        // Fourth rank (4 matches)
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH) // Bonus doesn't matter for fourth rank

        // Fifth rank (3 matches)
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH) // Bonus doesn't matter for fifth rank

        // No rank (0, 1, 2 matches)
        assertThat(Rank.valueOf(2, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.valueOf(2, true)).isEqualTo(Rank.NONE)
        assertThat(Rank.valueOf(1, false)).isEqualTo(Rank.NONE)
        assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.NONE)
    }

    @Test
    fun `has correct prize amounts`() {
        assertThat(Rank.FIRST.prize).isEqualTo(2_000_000_000)
        assertThat(Rank.SECOND.prize).isEqualTo(30_000_000)
        assertThat(Rank.THIRD.prize).isEqualTo(1_500_000)
        assertThat(Rank.FOURTH.prize).isEqualTo(50_000)
        assertThat(Rank.FIFTH.prize).isEqualTo(5_000)
        assertThat(Rank.NONE.prize).isEqualTo(0)
    }

    @Test
    fun `has correct descriptions`() {
        assertThat(Rank.FIRST.description).isEqualTo("6 Matches")
        assertThat(Rank.SECOND.description).isEqualTo("5 Matches + Bonus Ball")
        assertThat(Rank.THIRD.description).isEqualTo("5 Matches")
        assertThat(Rank.FOURTH.description).isEqualTo("4 Matches")
        assertThat(Rank.FIFTH.description).isEqualTo("3 Matches")
    }
}