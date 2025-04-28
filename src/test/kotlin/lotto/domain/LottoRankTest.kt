package lotto.domain

import lotto.LottoRank
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.assertj.core.api.Assertions.assertThat

class LottoRankTest {

    @Test
    fun `LottoRank should have correct match count values`() {
        // given
        val expectedMatchCounts = mapOf(
            LottoRank.FIRST to 6,
            LottoRank.SECOND to 5,
            LottoRank.THIRD to 5,
            LottoRank.FOURTH to 4,
            LottoRank.FIFTH to 3
        )

        // when & then
        assertAll(
            { assertThat(LottoRank.FIRST.matchCount).isEqualTo(expectedMatchCounts[LottoRank.FIRST]) },
            { assertThat(LottoRank.SECOND.matchCount).isEqualTo(expectedMatchCounts[LottoRank.SECOND]) },
            { assertThat(LottoRank.THIRD.matchCount).isEqualTo(expectedMatchCounts[LottoRank.THIRD]) },
            { assertThat(LottoRank.FOURTH.matchCount).isEqualTo(expectedMatchCounts[LottoRank.FOURTH]) },
            { assertThat(LottoRank.FIFTH.matchCount).isEqualTo(expectedMatchCounts[LottoRank.FIFTH]) },
        )
    }

    @Test
    fun `LottoRank should have correct prize values`() {
        // given
        val expectedPrizes = mapOf(
            LottoRank.FIRST to 2_000_000_000L,
            LottoRank.SECOND to 30_000_000L,
            LottoRank.THIRD to 1_500_000L,
            LottoRank.FOURTH to 50_000L,
            LottoRank.FIFTH to 5_000L,
            LottoRank.MISS to 0L
        )

        // when & then
        assertAll(
            { assertThat(LottoRank.FIRST.prize).isEqualTo(expectedPrizes[LottoRank.FIRST]) },
            { assertThat(LottoRank.SECOND.prize).isEqualTo(expectedPrizes[LottoRank.SECOND]) },
            { assertThat(LottoRank.THIRD.prize).isEqualTo(expectedPrizes[LottoRank.THIRD]) },
            { assertThat(LottoRank.FOURTH.prize).isEqualTo(expectedPrizes[LottoRank.FOURTH]) },
            { assertThat(LottoRank.FIFTH.prize).isEqualTo(expectedPrizes[LottoRank.FIFTH]) },
            { assertThat(LottoRank.MISS.prize).isEqualTo(expectedPrizes[LottoRank.MISS]) }
        )
    }

    @Test
    fun `valueOf should return the correct rank based on match count and bonus match`() {
        // given
        val testCases = listOf(
            Triple(6, false, LottoRank.FIRST),
            Triple(6, true, LottoRank.FIRST),  // Bonus doesn't matter for 6 matches
            Triple(5, true, LottoRank.SECOND),
            Triple(5, false, LottoRank.THIRD),
            Triple(4, false, LottoRank.FOURTH),
            Triple(4, true, LottoRank.FOURTH), // Bonus doesn't matter for 4 matches
            Triple(3, false, LottoRank.FIFTH),
            Triple(3, true, LottoRank.FIFTH),  // Bonus doesn't matter for 3 matches
            Triple(2, false, LottoRank.MISS),
            Triple(2, true, LottoRank.MISS),
            Triple(1, false, LottoRank.MISS),
            Triple(0, false, LottoRank.MISS)
        )

        // when & then
        testCases.forEach { (matchCount, bonusMatch, expectedRank) ->
            val rank = LottoRank.valueOf(matchCount, bonusMatch)
            assertThat(rank).isEqualTo(expectedRank)
        }
    }

    @Test
    fun `getFormattedDescription should return properly formatted strings`() {
        // given
        val expectedDescriptions = mapOf(
            LottoRank.FIRST to "6 Matches (2,000,000,000 KRW)",
            LottoRank.SECOND to "5 Matches + Bonus Ball (30,000,000 KRW)",
            LottoRank.THIRD to "5 Matches (1,500,000 KRW)",
            LottoRank.FOURTH to "4 Matches (50,000 KRW)",
            LottoRank.FIFTH to "3 Matches (5,000 KRW)",
            LottoRank.MISS to ""
        )

        // when & then
        assertAll(
            { assertThat(LottoRank.FIRST.getFormattedDescription()).isEqualTo(expectedDescriptions[LottoRank.FIRST]) },
            { assertThat(LottoRank.SECOND.getFormattedDescription()).isEqualTo(expectedDescriptions[LottoRank.SECOND]) },
            { assertThat(LottoRank.THIRD.getFormattedDescription()).isEqualTo(expectedDescriptions[LottoRank.THIRD]) },
            { assertThat(LottoRank.FOURTH.getFormattedDescription()).isEqualTo(expectedDescriptions[LottoRank.FOURTH]) },
            { assertThat(LottoRank.FIFTH.getFormattedDescription()).isEqualTo(expectedDescriptions[LottoRank.FIFTH]) },
            { assertThat(LottoRank.MISS.getFormattedDescription()).isEqualTo(expectedDescriptions[LottoRank.MISS]) }
        )
    }

    @Test
    fun `The miss rank should have zero prize and empty description`() {
        // given
        val missRank = LottoRank.MISS

        // when & then
        assertThat(missRank.prize).isEqualTo(0L)
        assertThat(missRank.getFormattedDescription()).isEmpty()
    }
}
