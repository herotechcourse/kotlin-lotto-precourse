package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @ParameterizedTest
    @CsvSource(
        "0, false, NONE",
        "1, false, NONE",
        "2, false, NONE",
        "3, false, FIFTH",
        "3, true, FIFTH",
        "4, false, FORTH",
        "4, true, FORTH",
        "5, false, THIRD",
        "5, true, SECOND",
        "6, false, FIRST",
        "6, true, FIRST",
    )
    fun `return Rank according to matchCount and isBonusMatch`(matchCount: Int, isBonusMatch: Boolean, expectedRank: Rank) {
        //when
        val result = Rank.updateRankCount(matchCount, isBonusMatch)

        //then
        assertThat(result).isEqualTo(expectedRank)
    }
}