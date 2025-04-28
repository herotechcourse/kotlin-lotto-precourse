package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PrizeRankTest {

    @ParameterizedTest
    @CsvSource(value = ["1, NONE", "2, NONE", "3, FIFTH", "4, FOURTH", "6, FIRST"])
    fun `should return prize rank based on matching count`(matchingCount: Int, prizeRank: PrizeRank) {
        // given
        val hasBonusNumber = true
        // when
        val result = PrizeRank.findBy(matchingCount, hasBonusNumber)
        // then
        assertThat(result).isEqualTo(prizeRank)
    }

    @ParameterizedTest
    @CsvSource(value = ["true, SECOND", "false, THIRD"])
    fun `should return prize rank based on bonus number when matching count is same`(
        hasBonusNumber: Boolean,
        prizeRank: PrizeRank
    ) {
        // given
        val matchingCount = 5
        // when
        val result = PrizeRank.findBy(matchingCount, hasBonusNumber)
        // then
        assertThat(result).isEqualTo(prizeRank)
    }
}
