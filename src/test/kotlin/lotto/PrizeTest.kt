package lotto

import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.ParameterizedTest
import org.assertj.core.api.Assertions.assertThat

class PrizeTest {
    @ParameterizedTest (name = "{index}. matchCount: {0}, hasBonus: {1}, Prize: {2}")
    @CsvSource(
        value = ["6,false,FIRST",
            "6,true,FIRST",
            "6,null,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,false,FOURTH",
            "4,true,FOURTH",
            "3,false,FIFTH",
            "3,true,FIFTH",
            "2,true,NONE",
            "2,false,NONE",
            "1,false,NONE",
            "0,false,NONE"], delimiter = ','
    )
    fun `test prize table`(matchCount: String, hasBonus: String, prize: Prize) {
        assertThat(Prize.from(matchCount.toInt(), hasBonus.toBoolean())).isEqualTo(prize)
    }

}