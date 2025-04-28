package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrizeRankTest {

    @Test
    fun `should return FIRST when 6 numbers match`() {
        val result = PrizeRank.from(matchCount = 6, bonusMatched = false)
        assertEquals(PrizeRank.FIRST, result)
    }

    @Test
    fun `should return SECOND when 5 numbers match and bonus matched`() {
        val result = PrizeRank.from(matchCount = 5, bonusMatched = true)
        assertEquals(PrizeRank.SECOND, result)
    }

    @Test
    fun `should return THIRD when 5 numbers match but bonus not matched`() {
        val result = PrizeRank.from(matchCount = 5, bonusMatched = false)
        assertEquals(PrizeRank.THIRD, result)
    }

    @Test
    fun `should return FOURTH when 4 numbers match`() {
        val result = PrizeRank.from(matchCount = 4, bonusMatched = false)
        assertEquals(PrizeRank.FOURTH, result)
    }

    @Test
    fun `should return FIFTH when 3 numbers match`() {
        val result = PrizeRank.from(matchCount = 3, bonusMatched = false)
        assertEquals(PrizeRank.FIFTH, result)
    }

    @Test
    fun `should return NONE when less than 3 numbers match`() {
        val resultWithTwoMatches = PrizeRank.from(matchCount = 2, bonusMatched = false)
        val resultWithOneMatch = PrizeRank.from(matchCount = 1, bonusMatched = false)
        val resultWithZeroMatch = PrizeRank.from(matchCount = 0, bonusMatched = false)

        assertEquals(PrizeRank.NONE, resultWithTwoMatches)
        assertEquals(PrizeRank.NONE, resultWithOneMatch)
        assertEquals(PrizeRank.NONE, resultWithZeroMatch)
    }
}