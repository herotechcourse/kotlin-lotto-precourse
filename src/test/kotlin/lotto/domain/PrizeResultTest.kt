package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeResultTest {

    @Test
    fun `increments rank count when rank is added`() {
        val prizeResult = PrizeResult()

        prizeResult.add(Rank.FOURTH)
        prizeResult.add(Rank.FOURTH)

        assertThat(prizeResult.getRankCount(Rank.FOURTH)).isEqualTo(2)
    }

    @Test
    fun `adds prize amount correctly`() {
        val prizeResult = PrizeResult()

        prizeResult.add(Rank.FIFTH)
        prizeResult.add(Rank.FOURTH)

        assertThat(prizeResult.totalPrize).isEqualTo(Rank.FIFTH.prize + Rank.FOURTH.prize)
    }

    @Test
    fun `returns zero when rank was never added`() {
        val prizeResult = PrizeResult()

        assertThat(prizeResult.getRankCount(Rank.FIRST)).isEqualTo(0)
    }
}
