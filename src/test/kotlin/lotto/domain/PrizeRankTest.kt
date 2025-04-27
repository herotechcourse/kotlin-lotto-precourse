package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PrizeRankTest {

    @Test
    fun `match count elss than 3 should return null`() {
        val rank0 = PrizeRank.from(0, false)
        val rank1 = PrizeRank.from(1, true)
        val rank2 = PrizeRank.from(2, false)

        assertThat(rank0).isNull()
        assertThat(rank1).isNull()
        assertThat(rank2).isNull()
    }

    @ParameterizedTest
    @CsvSource(value = [
        "3, false, FIFTH",
        "3, true, FIFTH",
        "4, false, FOURTH",
        "4, true, FOURTH",
        "5, false, THIRD",
        "5, true, SECOND",
        "6, false, FIRST",
        "6, true, FIRST"
    ])
    fun `should return correct rank based on match count and bonus`(
        matchCount: Int, hasBonus: Boolean, expectedRank: String
    ) {
        val actualRank = PrizeRank.from(matchCount, hasBonus)
        assertThat(actualRank).isEqualTo(PrizeRank.valueOf(expectedRank))
    }
}