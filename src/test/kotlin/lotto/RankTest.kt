package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RankTest {
    @Test
    @DisplayName("Rank.of returns FIRST when all 6 match and bonus doesn't matter")
    fun firstPrizeWhenAllMatch() {
        val rank = Rank.of(Config.RankConfig.FIRST_MATCH_COUNT, bonusMatched = false)
        assertThat(rank).isEqualTo(Rank.FIRST)
        assertThat(rank.prize).isEqualTo(Config.RankConfig.FIRST_PRIZE)
    }

    @Test
    @DisplayName("Rank.of returns SECOND when 5 match and bonus matches")
    fun secondPrizeWhenFiveMatchWithBonus() {
        val rank = Rank.of(Config.RankConfig.SECOND_MATCH_COUNT, bonusMatched = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
        assertThat(rank.prize).isEqualTo(Config.RankConfig.SECOND_PRIZE)
    }

    @Test
    @DisplayName("Rank.of returns THIRD when 5 match but bonus does not match")
    fun thirdPrizeWhenFiveMatchWithoutBonus() {
        val rank = Rank.of(Config.RankConfig.THIRD_MATCH_COUNT, bonusMatched = false)
        assertThat(rank).isEqualTo(Rank.THIRD)
        assertThat(rank.prize).isEqualTo(Config.RankConfig.THIRD_PRIZE)
    }

    @Test
    @DisplayName("Rank.of returns FOURTH when 4 match")
    fun fourthPrizeWhenFourMatch() {
        val rank = Rank.of(Config.RankConfig.FOURTH_MATCH_COUNT, bonusMatched = false)
        assertThat(rank).isEqualTo(Rank.FOURTH)
        assertThat(rank.prize).isEqualTo(Config.RankConfig.FOURTH_PRIZE)
    }

    @Test
    @DisplayName("Rank.of returns FIFTH when 3 match")
    fun fifthPrizeWhenThreeMatch() {
        val rank = Rank.of(Config.RankConfig.FIFTH_MATCH_COUNT, bonusMatched = false)
        assertThat(rank).isEqualTo(Rank.FIFTH)
        assertThat(rank.prize).isEqualTo(Config.RankConfig.FIFTH_PRIZE)
    }

    @Test
    @DisplayName("Rank.of returns NONE for less than 3 matches regardless of bonus")
    fun noneWhenLessThanThreeMatch() {
        val rankNoBonus = Rank.of(2, bonusMatched = false)
        val rankWithBonus = Rank.of(2, bonusMatched = true)
        assertThat(rankNoBonus).isEqualTo(Rank.NONE)
        assertThat(rankWithBonus).isEqualTo(Rank.NONE)
        assertThat(rankNoBonus.prize).isZero()
    }

    @Test
    @DisplayName("Rank.of returns SECOND when 5 match and bonus irrelevant for non-bonus-required ranks")
    fun secondWhenFiveMatchAndBonusTrue() {
        val rank = Rank.of(Config.RankConfig.THIRD_MATCH_COUNT, bonusMatched = true)
        assertThat(rank).isEqualTo(Rank.SECOND)
    }
}
