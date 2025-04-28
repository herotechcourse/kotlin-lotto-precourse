package lotto

import lotto.domain.MatchLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MatchLottoTest {
    @Test
    fun shouldReturnFirstPrizeWhenSixMatches() {
        assertThat(MatchLotto.from(6, false)).isEqualTo(MatchLotto.FIRST)
    }

    @Test
    fun shouldReturnSecondPrizeWhenFiveMatchesAndBonus() {
        assertThat(MatchLotto.from(5, true)).isEqualTo(MatchLotto.SECOND)
    }

    @Test
    fun shouldReturnThirdPrizeWhenFiveMatchesWithoutBonus() {
        assertThat(MatchLotto.from(5, false)).isEqualTo(MatchLotto.THIRD)
    }

    @Test
    fun shouldReturnFourthPrizeWhenFourMatches() {
        assertThat(MatchLotto.from(4, false)).isEqualTo(MatchLotto.FOURTH)
    }

    @Test
    fun shouldReturnFifthPrizeWhenThreeMatches() {
        assertThat(MatchLotto.from(3, false)).isEqualTo(MatchLotto.FIFTH)
    }

    @Test
    fun shouldReturnNoneWhenLessThanThreeMatches() {
        assertThat(MatchLotto.from(2, false)).isEqualTo(MatchLotto.NONE)
    }
}
