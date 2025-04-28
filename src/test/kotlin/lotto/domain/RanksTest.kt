package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RanksTest {

    private val ranks = Ranks()

    @Test
    fun `should be sorting by prize number`() {
        // when
        val ranks = Ranks().sortedByPrize()

        // then
        assertThat(ranks.size).isEqualTo(5)
        assertThat(ranks[0]).isEqualTo(Rank.FIFTH)
        assertThat(ranks[1]).isEqualTo(Rank.FOURTH)
        assertThat(ranks[2]).isEqualTo(Rank.THIRD)
        assertThat(ranks[3]).isEqualTo(Rank.SECOND)
        assertThat(ranks[4]).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `Ranks returns Rank when found by match count and bonus ball matched`() {
        val rank = Ranks().getOrNull(Rank.FIFTH.matchCount, Rank.FIFTH.bonusBallRequired)
        assertThat(rank).isNotNull()
    }

    @Test
    fun `Ranks returns null when can not found by matched count and bonus ball matched`() {
        val rank = Ranks().getOrNull(0, Rank.FIFTH.bonusBallRequired)
        assertThat(rank).isNull()
    }

    @Test
    fun `Ranks return mutable map when use createCounter()`() {
        val counter = Ranks().createCounter()
        assertThat(counter.size).isEqualTo(5)
        assertEquals(counter.values.toString(), listOf(0,0,0,0,0).toString())
    }


    @Test
    fun `matchCount 6 should return FIRST`() {
        val result = ranks.getOrNull(6, bonusBallMatched = false)
        assertThat(result).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `matchCount 5 with bonusBallMatched true should return SECOND`() {
        val result = ranks.getOrNull(5, bonusBallMatched = true)
        assertThat(result).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `matchCount 5 with bonusBallMatched false should return THIRD`() {
        val result = ranks.getOrNull(5, bonusBallMatched = false)
        assertThat(result).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `matchCount 4 should return FOURTH`() {
        val result = ranks.getOrNull(4, bonusBallMatched = false)
        assertThat(result).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `matchCount 3 should return FIFTH`() {
        val result = ranks.getOrNull(3, bonusBallMatched = false)
        assertThat(result).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `matchCount 2 should return null`() {
        val result = ranks.getOrNull(2, bonusBallMatched = false)
        assertThat(result).isNull()
    }

    @Test
    fun `matchCount 0 should return null`() {
        val result = ranks.getOrNull(0, bonusBallMatched = false)
        assertThat(result).isNull()
    }
}
