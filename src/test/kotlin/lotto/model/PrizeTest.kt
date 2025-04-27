package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PrizeTest {

    @ParameterizedTest
    @CsvSource(
        "6,false,FIRST",
        "5,true,SECOND",
        "5,false,THIRD",
        "4,false,FOURTH",
        "3,false,FIFTH",
        "2,false,MISS",
        "0,false,MISS"
    )
    fun `returns correct Prize depending on matchCount and bonus`(
        matchCount: Int,
        bonusMatch: Boolean,
        expectedPrize: Prize
    ) {
        val prize = Prize.of(matchCount, bonusMatch)

        assertThat(prize).isEqualTo(expectedPrize)
    }

    @Test
    fun `output text matches expected for each Prize`() {
        assertThat(Prize.FIRST.output).isEqualTo("6 Matches (2,000,000,000 KRW)")
        assertThat(Prize.SECOND.output).isEqualTo("5 Matches + Bonus Ball (30,000,000 KRW)")
        assertThat(Prize.THIRD.output).isEqualTo("5 Matches (1,500,000 KRW)")
        assertThat(Prize.FOURTH.output).isEqualTo("4 Matches (50,000 KRW)")
        assertThat(Prize.FIFTH.output).isEqualTo("3 Matches (5,000 KRW)")
        assertThat(Prize.MISS.output).isEqualTo("0 Matches (0 KRW)")
    }
}
