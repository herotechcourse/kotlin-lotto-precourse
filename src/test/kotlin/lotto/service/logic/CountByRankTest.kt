package lotto.service.logic

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

import lotto.domain.Rank

class CountByRankTest {

    @Test
    fun `givenListOfRanks_whenCountByRank_thenReturnsMapWithCounts`() {
        val input = listOf(
            Rank.FIFTH,
            Rank.FOURTH,
            Rank.THIRD,
            Rank.FOURTH,
            Rank.SECOND,
            Rank.FIRST
        )
        val expected = mapOf(
            Rank.FIRST to 1,
            Rank.SECOND to 1,
            Rank.THIRD to 1,
            Rank.FOURTH to 2,
            Rank.FIFTH to 1
        )

        val result = countByRank(input)
        assertEquals(expected, result)
    }
}