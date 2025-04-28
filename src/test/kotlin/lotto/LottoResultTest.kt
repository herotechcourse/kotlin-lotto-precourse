package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {
    
    @ParameterizedTest
    @CsvSource(
        "6,false,FIRST",
        "6,true,FIRST",   // Even with bonus, 6 matches is still 1st prize
        "5,true,SECOND",
        "5,false,THIRD",
        "4,true,FOURTH",  // Bonus doesn't affect 4 matches
        "4,false,FOURTH",
        "3,true,FIFTH",   // Bonus doesn't affect 3 matches
        "3,false,FIFTH",
        "2,false,NONE",
        "1,false,NONE",
        "0,false,NONE"
    )
    fun `from should return correct result`(matchCount: Int, hasBonusMatch: Boolean, expected: LottoResult) {
        assertThat(LottoResult.from(matchCount, hasBonusMatch)).isEqualTo(expected)
    }
}