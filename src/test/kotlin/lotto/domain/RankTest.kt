package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @Test
    fun `FIRST rank has correct values`() {
        assertThat(Rank.FIRST.matchCount).isEqualTo(6)
        assertThat(Rank.FIRST.hasBonus).isFalse
        assertThat(Rank.FIRST.prize).isEqualTo(2_000_000_000)
        assertThat(Rank.FIRST.description).isEqualTo("6 Matches (2,000,000,000 KRW)")
    }

    @Test
    fun `SECOND rank has correct values`() {
        assertThat(Rank.SECOND.matchCount).isEqualTo(5)
        assertThat(Rank.SECOND.hasBonus).isTrue
        assertThat(Rank.SECOND.prize).isEqualTo(30_000_000)
        assertThat(Rank.SECOND.description).isEqualTo("5 Matches + Bonus Ball (30,000,000 KRW)")
    }

    @Test
    fun `THIRD rank has correct values`() {
        assertThat(Rank.THIRD.matchCount).isEqualTo(5)
        assertThat(Rank.THIRD.hasBonus).isFalse
        assertThat(Rank.THIRD.prize).isEqualTo(1_500_000)
        assertThat(Rank.THIRD.description).isEqualTo("5 Matches (1,500,000 KRW)")
    }

    @Test
    fun `FOURTH rank has correct values`() {
        assertThat(Rank.FOURTH.matchCount).isEqualTo(4)
        assertThat(Rank.FOURTH.hasBonus).isFalse
        assertThat(Rank.FOURTH.prize).isEqualTo(50_000)
        assertThat(Rank.FOURTH.description).isEqualTo("4 Matches (50,000 KRW)")
    }

    @Test
    fun `FIFTH rank has correct values`() {
        assertThat(Rank.FIFTH.matchCount).isEqualTo(3)
        assertThat(Rank.FIFTH.hasBonus).isFalse
        assertThat(Rank.FIFTH.prize).isEqualTo(5_000)
        assertThat(Rank.FIFTH.description).isEqualTo("3 Matches (5,000 KRW)")
    }

    @Test
    fun `NONE rank has correct values`() {
        assertThat(Rank.NONE.matchCount).isEqualTo(0)
        assertThat(Rank.NONE.hasBonus).isFalse
        assertThat(Rank.NONE.prize).isEqualTo(0)
        assertThat(Rank.NONE.description).isEqualTo("No Matches")
    }

    @ParameterizedTest
    @CsvSource(
        "6, false, FIRST",
        "5, true, SECOND",
        "5, false, THIRD",
        "4, false, FOURTH",
        "3, false, FIFTH",
        "2, false, NONE",
        "1, false, NONE",
        "0, false, NONE"
    )
    fun `getRank returns correct rank`(matchCount: Int, hasBonus: Boolean, expectedRank: Rank) {
        val rank = Rank.getRank(matchCount, hasBonus)
        assertThat(rank).isEqualTo(expectedRank)
    }
}
