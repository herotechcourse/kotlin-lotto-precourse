package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PrizeRankTest {

    @ParameterizedTest
    @CsvSource(
        "6, false, SIX_MATCH",
        "6, true, SIX_MATCH",
        "5, true, FIVE_MATCH_BONUS",
        "5, false, FIVE_MATCH",
        "4, false, FOUR_MATCH",
        "4, true, FOUR_MATCH",
        "3, false, THREE_MATCH",
        "3, true, THREE_MATCH",
        "2, false, NONE",
        "2, true, NONE",
        "1, false, NONE",
        "0, false, NONE"
    )
    fun `from should return correct prize rank based on match count and bonus status`(
        matchCount: Int,
        matchBonus: Boolean,
        expectedRank: PrizeRank
    ) {
        val result = PrizeRank.from(matchCount, matchBonus)
        assertThat(result).isEqualTo(expectedRank)
    }

    @ParameterizedTest
    @CsvSource(
        "SIX_MATCH, 6, false, 2000000000",
        "FIVE_MATCH_BONUS, 5, true, 30000000",
        "FIVE_MATCH, 5, false, 1500000",
        "FOUR_MATCH, 4, false, 50000",
        "THREE_MATCH, 3, false, 5000",
        "NONE, 0, false, 0"
    )
    fun `prize ranks should have correct properties`(
        rank: PrizeRank,
        expectedMatchCount: Int,
        expectedRequireBonus: Boolean,
        expectedPrize: Int
    ) {
        assertThat(rank.matchCount).isEqualTo(expectedMatchCount)
        assertThat(rank.requireBonus).isEqualTo(expectedRequireBonus)
        assertThat(rank.prize).isEqualTo(expectedPrize)
    }
}