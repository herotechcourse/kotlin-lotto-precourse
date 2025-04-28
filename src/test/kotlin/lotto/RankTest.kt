package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RankTest {
    @Test
    fun `FIRST rank has correct values`() {
        assertThat(Rank.FIRST.matchCount).isEqualTo(6)
        assertThat(Rank.FIRST.matchBonus).isFalse
        assertThat(Rank.FIRST.prize).isEqualTo(2_000_000_000)
    }
    
    @Test
    fun `SECOND rank requires bonus number match`() {
        assertThat(Rank.SECOND.matchCount).isEqualTo(5)
        assertThat(Rank.SECOND.matchBonus).isTrue
    }
    
    @ParameterizedTest
    @CsvSource(
        "6, false, FIRST",
        "5, true, SECOND",
        "5, false, THIRD",
        "4, false, FOURTH",
        "3, false, FIFTH"
    )
    fun `getByMatchCountAndBonus returns correct rank`(matchCount: Int, matchBonus: Boolean, expectedRank: Rank) {
        val rank = Rank.getByMatchCountAndBonus(matchCount, matchBonus)
        assertThat(rank).isEqualTo(expectedRank)
    }
    
    @Test
    fun `getByMatchCountAndBonus returns null for non-winning combinations`() {
        val rank = Rank.getByMatchCountAndBonus(2, false)
        assertThat(rank).isNull()
    }
} 