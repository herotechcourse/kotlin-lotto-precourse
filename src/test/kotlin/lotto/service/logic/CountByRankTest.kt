package lotto.service.logic

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CountByRankTest {

    enum class FakeRank {
        FIRST,
        SECOND,
        THIRD,
        FOURTH,
        FIFTH
    }

    @Test
    fun `givenListOfRanks_whenCountByRank_thenReturnsMapWithCounts`() {
        val input = listOf(
            FakeRank.FIFTH,
            FakeRank.FOURTH,
            FakeRank.THIRD,
            FakeRank.FOURTH,
            FakeRank.SECOND,
            FakeRank.FIRST
        )
        val expected = mapOf(
            FakeRank.FIRST to 1,
            FakeRank.SECOND to 1,
            FakeRank.THIRD to 1,
            FakeRank.FOURTH to 2,
            FakeRank.FIFTH to 1
        )
        val result = countByRank(input)

        assertEquals(expected, result)
    }
}