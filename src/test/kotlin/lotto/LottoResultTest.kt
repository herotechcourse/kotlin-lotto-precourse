package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `total prize should return correct results based on ranks`() {
        val result = LottoResult(listOf(Rank.SECOND, Rank.FIFTH))

        val expected = Rank.SECOND.prize + Rank.FIFTH.prize

        assertThat(result.totalPrize()).isEqualTo(expected)
    }

    @Test
    fun `ranks counts should be calculated correctly based on ranks`() {
        val result = LottoResult(listOf(Rank.NONE, Rank.NONE, Rank.FIFTH, Rank.FOURTH))

        val counts = result.getRankCounts()
        assertThat(counts[Rank.FOURTH]).isEqualTo(1)
        assertThat(counts[Rank.FIFTH]).isEqualTo(1)
        assertThat(counts[Rank.NONE]).isEqualTo(2)
    }
}