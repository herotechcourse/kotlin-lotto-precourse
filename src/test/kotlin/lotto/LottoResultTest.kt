package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `getRankCounts counts occurrences correctly`() {
        val result = LottoResult(
            listOf(Rank.FIRST, Rank.THIRD, Rank.FIFTH, Rank.FIFTH, Rank.NONE)
        )

        val counts = result.getRankCounts()
        assertThat(counts[Rank.FIRST]).isEqualTo(1)
        assertThat(counts[Rank.THIRD]).isEqualTo(1)
        assertThat(counts[Rank.FIFTH]).isEqualTo(2)
        assertThat(counts[Rank.NONE]).isEqualTo(1)
    }

    @Test
    fun `totalPrize sums up all prizes correctly`() {
        val result = LottoResult(
            listOf(Rank.FIRST, Rank.SECOND, Rank.FOURTH)
        )

        val expectedTotal =
            Rank.FIRST.prize +
                    Rank.SECOND.prize +
                    Rank.FOURTH.prize

        assertThat(result.totalPrize()).isEqualTo(expectedTotal)
    }
}