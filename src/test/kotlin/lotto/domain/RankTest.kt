package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    fun `Rank from maps correct match counts to ranks`() {
        assertThat(Rank.from(6, false)).isEqualTo(Rank.FIRST)
        assertThat(Rank.from(5, true)).isEqualTo(Rank.SECOND)
        assertThat(Rank.from(5, false)).isEqualTo(Rank.THIRD)
        assertThat(Rank.from(4, false)).isEqualTo(Rank.FOURTH)
        assertThat(Rank.from(3, false)).isEqualTo(Rank.FIFTH)
        assertThat(Rank.from(2, true)).isEqualTo(Rank.NONE)
        assertThat(Rank.from(0, false)).isEqualTo(Rank.NONE)
    }

    @Test
    fun `description formats correctly for each rank`() {
        // FIRST
        val firstDesc = Rank.FIRST.description(1)
        assertThat(firstDesc).contains("6 Matches", "2,000,000,000 KRW", "– 1 tickets")

        // SECOND (+ Bonus Ball)
        val secondDesc = Rank.SECOND.description(2)
        assertThat(secondDesc).contains("5 Matches + Bonus Ball", "30,000,000 KRW", "– 2 tickets")

        // THIRD
        val thirdDesc = Rank.THIRD.description(3)
        assertThat(thirdDesc).contains("5 Matches (1,500,000 KRW) – 3 tickets")
    }
}