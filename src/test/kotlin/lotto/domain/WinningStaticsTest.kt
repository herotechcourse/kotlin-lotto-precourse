package lotto.domain

import lotto.util.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningStaticsTest {
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
         "6, true, FIRST"
     )
     fun `update winning statics map`(matchCount: Int, isBonusMatch: Boolean, expectedRank: Rank) {
         //given
         val winningStatics = WinningStatics()

         //when
         winningStatics.updateWinningStatics(matchCount, isBonusMatch)

         //then
         val result = winningStatics.getStatics()
         assertThat(result[expectedRank]).isEqualTo(1)
     }
}