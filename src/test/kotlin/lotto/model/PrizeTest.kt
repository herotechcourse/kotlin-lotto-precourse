package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import lotto.common.ErrorMessages

class PrizeTest {

    @Nested
    @DisplayName("Prize constructor")
    inner class ConstructorTest {
        
        @Test
        @DisplayName("should throw an exception when matchCount is negative")
        fun throwsExceptionWhenMatchCountIsNegative() {
            assertThatThrownBy { Prize(-1, false) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ErrorMessages.INVALID_MATCH_COUNT_UNIT)
        }
        
        @ParameterizedTest
        @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6])
        @DisplayName("should create Prize instance with valid matchCount")
        fun createsPrizeWithValidMatchCount(matchCount: Int) {
            val prize = Prize(matchCount, false)
            assertThat(prize).isNotNull
        }
    }
    
    @Nested
    @DisplayName("getRank method")
    inner class GetRankTest {
        
        @Test
        @DisplayName("should return FIRST rank when matchCount is 6")
        fun returnFirstRankWhenMatchCountIs6() {
            val prize = Prize(6, false)
            assertThat(prize.getRank()).isEqualTo(Rank.FIRST)
        }
        
        @Test
        @DisplayName("should return SECOND rank when matchCount is 5 and bonus matches")
        fun returnSecondRankWhenMatchCountIs5AndBonusMatches() {
            val prize = Prize(5, true)
            assertThat(prize.getRank()).isEqualTo(Rank.SECOND)
        }
        
        @Test
        @DisplayName("should return THIRD rank when matchCount is 5 and bonus doesn't match")
        fun returnThirdRankWhenMatchCountIs5AndBonusDoesntMatch() {
            val prize = Prize(5, false)
            assertThat(prize.getRank()).isEqualTo(Rank.THIRD)
        }
        
        @Test
        @DisplayName("should return FOURTH rank when matchCount is 4")
        fun returnFourthRankWhenMatchCountIs4() {
            val prize = Prize(4, false)
            assertThat(prize.getRank()).isEqualTo(Rank.FOURTH)
        }
        
        @Test
        @DisplayName("should return FIFTH rank when matchCount is 3")
        fun returnFifthRankWhenMatchCountIs3() {
            val prize = Prize(3, false)
            assertThat(prize.getRank()).isEqualTo(Rank.FIFTH)
        }
        
        @ParameterizedTest
        @ValueSource(ints = [0, 1, 2])
        @DisplayName("should return NONE rank when matchCount is less than 3")
        fun returnNoneRankWhenMatchCountIsLessThan3(matchCount: Int) {
            val prize = Prize(matchCount, false)
            assertThat(prize.getRank()).isEqualTo(Rank.NONE)
        }
    }
    
    @Nested
    @DisplayName("getReward method")
    inner class GetRewardTest {
        
        @Test
        @DisplayName("should return FIRST rank reward when matchCount is 6")
        fun returnFirstRankRewardWhenMatchCountIs6() {
            val prize = Prize(6, false)
            assertThat(prize.getReward()).isEqualTo(Rank.FIRST.reward)
        }
        
        @Test
        @DisplayName("should return SECOND rank reward when matchCount is 5 and bonus matches")
        fun returnSecondRankRewardWhenMatchCountIs5AndBonusMatches() {
            val prize = Prize(5, true)
            assertThat(prize.getReward()).isEqualTo(Rank.SECOND.reward)
        }
        
        @Test
        @DisplayName("should return THIRD rank reward when matchCount is 5 and bonus doesn't match")
        fun returnThirdRankRewardWhenMatchCountIs5AndBonusDoesntMatch() {
            val prize = Prize(5, false)
            assertThat(prize.getReward()).isEqualTo(Rank.THIRD.reward)
        }
        
        @Test
        @DisplayName("should return FOURTH rank reward when matchCount is 4")
        fun returnFourthRankRewardWhenMatchCountIs4() {
            val prize = Prize(4, false)
            assertThat(prize.getReward()).isEqualTo(Rank.FOURTH.reward)
        }
        
        @Test
        @DisplayName("should return FIFTH rank reward when matchCount is 3")
        fun returnFifthRankRewardWhenMatchCountIs3() {
            val prize = Prize(3, false)
            assertThat(prize.getReward()).isEqualTo(Rank.FIFTH.reward)
        }
        
        @Test
        @DisplayName("should return NONE rank reward when matchCount is less than 3")
        fun returnNoneRankRewardWhenMatchCountIsLessThan3() {
            val prize = Prize(2, false)
            assertThat(prize.getReward()).isEqualTo(Rank.NONE.reward)
        }
    }
}